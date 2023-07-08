package W01ExerciseWorkingWithAbstraction.P03CardsWithPower;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankPower = scanner.nextLine();
        String suitPower = scanner.nextLine();

        Rank rank = Rank.valueOf(rankPower);
        Suit suit = Suit.valueOf(suitPower);

        System.out.printf("Card name: %s of %s; Card power: %d%n", rank.name(), suit.name(), rank.getCardPower() + suit.getSuitPower());



    }
}
