package W01ExerciseWorkingWithAbstraction.P02CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Ranks:");
        Arrays.stream(Rank.values()).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n", e.ordinal(), e.name()));

//        Решение на задачата с foreach
//        for (Rank value : Rank.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
//        }

    }
}
