import code.neurals.*;

public class Neurals {
    public static void main(String[] args) {
        // These 2 arrays represent the input and result data on a logical XOR gate
        double[][] xorIn = {
                {0, 0},
                {0, 1},
                {1, 0},
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
    }
}
