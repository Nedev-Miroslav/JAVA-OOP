package W01WorkingWithAbstraction;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int firstPart = 1; firstPart <= n; firstPart++) {
            printRow(n, firstPart);
        }

        for (int secondPart = n - 1; secondPart >= 1; secondPart--) {
            printRow(n, secondPart);
        }


    }

    private static void printRow(int n, int parts) {
        for (int spaces = n - parts; spaces > 0; spaces--) {
            System.out.print(" ");
        }
        for (int stars = n - parts; stars < n; stars++) {
            System.out.print("* ");
        }
        System.out.println();
    }


}
