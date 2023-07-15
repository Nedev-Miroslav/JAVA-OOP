package W05Polymorphism.P04WildFarm;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> list = new ArrayList<>();
        while (!"End".equals(input)) {

            Animal animal = null;
            String[] currentAnimalInput = input.split(" ");


            String type = currentAnimalInput[0];
            String name = currentAnimalInput[1];
            Double weight = Double.parseDouble(currentAnimalInput[2]);
            String livingRegion = currentAnimalInput[3];

            if ("Cat".equals(type)) {
                String breed = currentAnimalInput[4];
                animal = new Cat(name, type, weight, livingRegion, breed);


            } else if ("Tiger".equals(type)) {

                animal = new Tiger(name, type, weight, livingRegion);

            } else if ("Zebra".equals(type)) {
                animal = new Zebra(name, type, weight, livingRegion);

            } else if ("Mouse".equals(type)) {

                animal = new Mouse(name, type, weight, livingRegion);


            }

            Food food = null;
            String secondLine = scanner.nextLine();
            String[] currentFood = secondLine.split(" ");
            String foodType = currentFood[0];
            Integer quantity = Integer.parseInt(currentFood[1]);

            if ("Vegetable".equals(foodType)) {

                food = new Vegetable(quantity);


            } else if ("Meat".equals(foodType)) {
                food = new Meat(quantity);


            }
            animal.makeSound();
            animal.eat(food);

            list.add(animal);

            input = scanner.nextLine();

        }
        for (Animal animal : list) {
            System.out.println(animal);
        }

    }
}
