package code.neurals;

import java.util.ArrayList;
import java.util.List;

// Basic fundamentals of neural networking:
//  We need matrices to store pathway data
public class Matrix {
    public double[][] data;
    private int rows, cols;

    public Matrix(int rows, int cols) {
        this(rows, cols, true);
    }

    public Matrix(int rows, int cols, boolean fill) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];

        if (fill) {
            populate();
        }
    }

    // Initializes the matrix with values between -1 and 1
    public void populate() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = (Math.random() * 2) - 1;
            }
        }
    }

    // Adds a double value to each element of this class' data
    public void add(double scaler) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] += scaler;
            }
        }
    }

    // Adds a matrix' data to this matrix' data if it has the same dimensions
    public void add(Matrix other) throws Exception {
        // This should work, since we're comparing Matrix to Matrix (private fields)
        if (cols != other.cols || rows != other.rows) {
            throw new Exception("Matrix dimension mismatch");
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] += other.data[row][col];
            }
        }
    }

    // Subtract a matrix' data (other) from another (one)
    public static Matrix subtract(Matrix one, Matrix other) {
        Matrix output = new Matrix(one.rows, one.cols, false);

        for (int row = 0; row < one.rows; row++) {
            for (int col = 0; col < one.cols; col++) {
                output.data[row][col] = one.data[row][col] - other.data[row][col];
            }
        }

        return output;
    }

    public static Matrix multiply(Matrix one, Matrix other) {
        Matrix output = new Matrix(one.rows, other.cols, false);

        for (int row = 0; row < output.rows; row++) {
            for (int col = 0; col < output.cols; col++) {
                double sum = 0.0;

                for (int x = 0; x < one.cols; x++) {
                    sum += one.data[row][x] * other.data[x][col];
                }

                output.data[row][col] = sum;
            }
        }

        return output;
    }

    public void multiply(Matrix matrix) {
        for (int row = 0; row < matrix.rows; row++) {
            for (int col = 0; col < matrix.cols; col++) {
                this.data[row][col] *= matrix.data[row][col];
            }
        }
    }

    public void multiply(double multiplier) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] *= multiplier;
            }
        }
    }

    // If you've forgotten maths, transposing a matrix means transforming columns into rows and vice versa.
        /*   eg:
                1   2   3   4       >       1   5
                5   6   7   8               2   6
                                            3   7
                                            4   8
         */
    public static Matrix transpose(Matrix matrix) {
        Matrix output = new Matrix(matrix.cols, matrix.rows, false);

        for (int row = 0; row < matrix.rows; row++) {
            for (int col = 0; col < matrix.cols; col++) {
                output.data[col][row] = matrix.data[row][col];
            }
        }

        return output;
    }

    // Transforms values into a binary form - more specifically a probability towards 1 option or another
        /* Turns data into an S-shaped curve between 1 and -1, which can be squashed into 0 to 1 (absolute of neg)
                 |  ________
                 | /
        .........|/.........
                /|
        -------/ |
         */
    public void sigmoid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = 1 / (1 + Math.exp(-data[row][col]));
                // Negative exponential: exp(x, -n) = 1 / exp(x, n)
            }
        }
    }

    // Derivative of the sigmoid function
    // Necessary for the calculation of gradients for backpropagation (error weight calculation)
    public Matrix dsigmoid() {
        Matrix output = new Matrix(rows, cols, false);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output.data[row][col] = data[row][col] * (1 - data[row][col]);
            }
        }

        return output;
    }

    public static Matrix fromArray(double[] arr) {
        Matrix output = new Matrix(arr.length, 1, false);

        for (int x = 0; x < arr.length; x++) {
            output.data[x][0] = arr[x];
        }

        return output;
    }

    public static Matrix fromArray(double[][] arr) {
        Matrix output = new Matrix(arr.length, arr[0].length, false);

        for (int row = 0; row < output.rows; row++) {
            for (int col = 0; col < output.cols; col++) {
                output.data[row][col] = arr[row][col];
            }
        }

        return output;
    }

    public List<Double> toList() {
        List<Double> output = new ArrayList<Double>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output.add(data[row][col]);
            }
        }

        return output;
    }
}
