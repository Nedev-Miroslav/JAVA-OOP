package W07ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
     
        System.out.printf("Range: [%d...%d]%n", start, end);


        for (; ; ) {
            String currentInput = scanner.nextLine();


            try {
                int num = Integer.parseInt(currentInput);
                if (num >= start && num <= end) {

                    System.out.printf("Valid number: %d%n", num);
                    break;
                } else {
                    System.out.printf("Invalid number: %d%n", num);
                }
            } catch (NumberFormatException exception) {
                System.out.printf("Invalid number: %s%n", currentInput);
            }


        }


    }


}
