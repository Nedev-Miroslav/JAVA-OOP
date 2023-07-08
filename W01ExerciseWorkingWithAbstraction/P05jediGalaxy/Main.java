package W01ExerciseWorkingWithAbstraction.P05jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FieldMatrix fieldMatrix = new FieldMatrix();
        int[][] field = fieldMatrix.readAndFillMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvil(fieldMatrix, field, evilPosition);

            sum = moveJedi(fieldMatrix, field, sum, jediPosition);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long moveJedi(FieldMatrix fieldMatrix, int[][] field, long sum, int[] jediPosition) {
        int jediRow = jediPosition[0];
        int jediCol = jediPosition[1];

        while (jediRow >= 0 && jediCol < field[1].length) {
            if (fieldMatrix.isInBounds(field, jediRow, jediCol)) {
                sum += field[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static void moveEvil(FieldMatrix fieldMatrix, int[][] field, int[] evilPosition) {
        int evelRow = evilPosition[0];
        int evelCol = evilPosition[1];

        while (evelRow >= 0 && evelCol >= 0) {
            if (fieldMatrix.isInBounds(field, evelRow, evelCol)) {
                field[evelRow][evelCol] = 0;
            }
            evelRow--;
            evelCol--;
        }
    }


}
