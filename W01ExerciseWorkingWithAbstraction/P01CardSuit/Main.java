package W01ExerciseWorkingWithAbstraction.P01CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Suits:");
        Arrays.stream(Suit.values()).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n", e.ordinal(), e.name()));

//        Решение на задачата с foreach
//        System.out.println("Card Suits:");
//        for (Suit value : Suit.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
//        }

    }
}
