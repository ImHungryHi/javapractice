import code.neurals.*;

import java.util.List;

public class Neurals {
    public static void main(String[] args) throws Exception {
        // These 2 arrays represent the input and result data on a logical XOR gate
        double[][] xorIn = {
                {0, 0},
                {1, 0},
                {0, 1},
                {1, 1}
        };
        double[][] xorOut = {
                {0},
                {1},
                {1},
                {0}
        };

        // Let's create a neural network to unleash and train on this data
        NeuralNetwork neuralNet = new NeuralNetwork(2,10,1);
        neuralNet.fit(xorIn, xorOut, 50000);

        double[][] input = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        List<Double> output;

        for (double[] row : input) {
            output = neuralNet.predict(row);
            System.out.println(output.toString());
        }
    }
}
