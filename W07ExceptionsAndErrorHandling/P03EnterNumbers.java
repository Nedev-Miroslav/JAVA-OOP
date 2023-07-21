package W07ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> list = new ArrayList<>();

        while (list.size() < 10) {


            int n = isNumInBoundsOf1to100(start, end, scanner);
            if (n < 0){
                System.out.printf("Your number is not in range %d - 100!%n", start);
                continue;
            } else if (n < 1) {
                continue;
            }
            list.add(n);

            start = n;



        }


        System.out.println(String.valueOf(list).replaceAll("[\\[\\]]", ""));


    }
    private static int isNumInBoundsOf1to100(int start, int end, Scanner scanner){
        String input = scanner.nextLine();
        int toReturn = 0;
        try {
            int num = Integer.parseInt(input);
            if (num > start && num < end){
                toReturn = num;
                return num;
            } else {
                toReturn = -1;
            }

        } catch (NumberFormatException exception){
            System.out.println("Invalid Number!");

        }

        return toReturn;


    }

}
