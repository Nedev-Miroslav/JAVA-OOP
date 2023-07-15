package W05ExercisesPolymorphism.P01Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCar = scanner.nextLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(inputCar[1]);
        double consumPerKmCar = Double.parseDouble(inputCar[2]);
        Car car = new Car(fuelQuantityCar, consumPerKmCar);


        String[] inputTruck = scanner.nextLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
        double consumPerKmTruck = Double.parseDouble(inputTruck[2]);


        Truck truck = new Truck(fuelQuantityTruck, consumPerKmTruck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String currentCommand = commandParts[0];

            if ("Drive".equals(currentCommand)) {
                if (commandParts[1].equals("Car")) {
                    double distance = Double.parseDouble(commandParts[2]);

                    System.out.println(car.driving(distance));

                } else if (commandParts[1].equals("Truck")) {
                    double distance = Double.parseDouble(commandParts[2]);

                    System.out.println(truck.driving(distance));
                }


            } else if ("Refuel".equals(currentCommand)) {
                double refuel = Double.parseDouble(commandParts[2]);
                if (commandParts[1].equals("Car")) {
                    car.refuel(refuel);
                } else if (commandParts[1].equals("Truck")) {
                    truck.refuel(refuel);
                }
            }


        }
        System.out.println(car);
        System.out.println(truck);


    }
}
