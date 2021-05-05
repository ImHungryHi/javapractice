package code.neurals;

import java.util.List;


// Neural networks are a type of computational system not unlike the human brain, in a smaller manner.
// Take the following graphic:
/* Each I is connected to each H, which in turn are connected to each O
    ___ H___
   /  /   \ \
  -|-I     O-|-
 / |  \   /  | \
 | |    H    | |
 |  \ /   \ /  |
 |   I     O   |
  \   \   /   /
   ---- H ----

   An Input connects to a Hidden node, which in turn connects to an Output using lines we call Synapses.
     The nodes are called Neurons. The learning process is influenced by calculated Weights to pick certain
     synapses. This calculation happens through backpropagation (backwards propagation of errors) - which adjusts
     weights to let the input neurons know which synapses contain the lowest error possibility.
 */
public class NeuralNetwork {
    private Matrix weights_ih, // Input to hidden
            weights_ho, // Hidden to output
            bias_h, // Bias for hidden - helps influence the decision process along with weights
            bias_o; // Bias for output - works similar to weights
    private double l_rate = 0.01; // Learning rate - controls the learning steps during optimization of weights

    public NeuralNetwork(int inputs, int hiddens, int outputs) {
        weights_ih = new Matrix(hiddens, inputs);
        weights_ho = new Matrix(outputs, hiddens);
        bias_h = new Matrix(hiddens, 1);
        bias_o = new Matrix(outputs, 1);
    }

    // Forward (pass/) propagation on the neural network
    //  = generates a prediction from the network based on multiplication
    //    with input and weights, adding biases and activating sigmoids to end up being flattened into a list
        /*
            1 ----------bias
                        \
            X1 ---------- (f(w1.X1 + w2.X2 + b) -> Y (output)
             weight1    /
                       /
            X2 --------weight2
         */
    public List<Double> predict(double[] arr) throws Exception {
        Matrix input = Matrix.fromArray(arr);
        Matrix hidden = Matrix.multiply(weights_ih, input);
        hidden.add(bias_h);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(weights_ho, hidden);
        output.add(bias_o);
        output.sigmoid();

        return output.toList();
    }

    // The output from the forward pass is subtracted from the target (y in matrix form)
    //  The result from this subtraction is the error in the current sample passed.
    //   This error is used to calculate gradients for the backpropagation.
    //  The output from the forward pass is calculated into a derivated sigmoid and returns a gradient matrix
    //      to multiply by the output errors and the learning rate to decide the learning step.
    // Backpropagation is the reverse of the forward pass in which we take the transpose of the weight matrices
    //      and multiply them with the gradient calculated from the errors, which in turn return the deltas that
    //      are used to adjust the weights in the current layer. Using the gradients, the biases are updated
    //  Repeat for both layers (o-h & h-i) to calculate the weights of all layers
    public void train(double[] x, double[] y) throws Exception {
        Matrix input = Matrix.fromArray(x);
        Matrix hidden = Matrix.multiply(weights_ih, input);
        hidden.add(bias_h);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(weights_ho, hidden);
        output.add(bias_o);
        output.sigmoid();

        Matrix target = Matrix.fromArray(y);

        Matrix error = Matrix.subtract(target, output);
        Matrix gradient = output.dsigmoid();
        gradient.multiply(error);
        gradient.multiply(l_rate);

        // Calculate the difference between hidden-output matrices with weights
        Matrix hidden_T = Matrix.transpose(hidden);
        Matrix who_delta = Matrix.multiply(gradient, hidden_T);

        weights_ho.add(who_delta);
        bias_o.add(gradient);

        Matrix who_T = Matrix.transpose(weights_ho);
        Matrix hidden_errors = Matrix.multiply(who_T, error);

        Matrix h_gradient = hidden.dsigmoid();
        h_gradient.multiply(hidden_errors);
        h_gradient.multiply(l_rate);

        Matrix i_T = Matrix.transpose(input);
        Matrix wih_delta = Matrix.multiply(h_gradient, i_T);

        weights_ih.add(wih_delta);
        bias_h.add(h_gradient);
    }

    // Epochs = amount of times to iterate over the dataset
    // Iterates and trains multiple times with random data points to generalize the network over the dataset
    public void fit(double[][] x, double[][] y, int epochs) throws Exception {
        for (int i = 0; i < epochs; i++) {
            int sampleN = (int)(Math.random() * x.length);
            this.train(x[sampleN], y[sampleN]);
        }
    }
}
