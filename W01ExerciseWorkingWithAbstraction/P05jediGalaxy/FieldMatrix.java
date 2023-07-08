package W01ExerciseWorkingWithAbstraction.P05jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class FieldMatrix {

    private int[][] field;
    private int row;
    private int col;

    public FieldMatrix() {
        this.field = new int[row][col];
    }

    public int[][] readAndFillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] fieldMatrix = new int[rows][cols];

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                fieldMatrix[row][col] = value++;
            }
        }
        return fieldMatrix;
    }

    public boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length & c >= 0 && c < matrix[r].length;

    }


}
