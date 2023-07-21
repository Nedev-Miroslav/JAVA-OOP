package W07ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int num = Integer.parseInt(input);
            sqrtChecker(num);
            double result = Math.sqrt(num);
            System.out.printf("%.2f%n", result);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }


    }

    private static double sqrtChecker(int num) {
        if (num < 0) {
            throw new NumberFormatException("Invalid");
        } else {
            return num;
        }
    }

}
