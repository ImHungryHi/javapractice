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
        double[][] input = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        List<Double> output;

        // We first fit input and example output into a neural net and then loop through every input
        //   to predict its outcome. Do this over and over with the same data and we'll narrow it down.
        for (int x = 0; x < 10000; x++) {
            neuralNet.fit(xorIn, xorOut, 50000);

            for (double[] row : input) {
                output = neuralNet.predict(row);
                System.out.println("[" + (int) row[0] + ", " + (int) row[1] + "] " + output.toString());
            }

            System.out.println("============================= [" + String.format("%05d", x + 1) + "/10000]=============================");
        }
    }
}
