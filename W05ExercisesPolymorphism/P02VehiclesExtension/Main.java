package W05ExercisesPolymorphism.P02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCar = scanner.nextLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(inputCar[1]);
        double consumPerKmCar = Double.parseDouble(inputCar[2]);
        double tankCapacityCar = Double.parseDouble(inputCar[3]);
        Car car = new Car(fuelQuantityCar, consumPerKmCar, tankCapacityCar);


        String[] inputTruck = scanner.nextLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
        double consumPerKmTruck = Double.parseDouble(inputTruck[2]);
        double tankCapacityTruck = Double.parseDouble(inputTruck[3]);
        Truck truck = new Truck(fuelQuantityTruck, consumPerKmTruck, tankCapacityTruck);


        String[] inputBus = scanner.nextLine().split("\\s+");
        double fuelQuantityBus = Double.parseDouble(inputBus[1]);
        double consumPerKmBus = Double.parseDouble(inputBus[2]);
        double tankCapacityBus = Double.parseDouble(inputBus[3]);
        Bus bus = new Bus(fuelQuantityBus, consumPerKmBus, tankCapacityBus);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String currentCommand = commandParts[0];

            double distance = Double.parseDouble(commandParts[2]);
            try {


                if ("Drive".equals(currentCommand)) {
                    if (commandParts[1].equals("Car")) {

                        System.out.println(car.driving(distance));

                    } else if (commandParts[1].equals("Truck")) {
                        distance = Double.parseDouble(commandParts[2]);

                        System.out.println(truck.driving(distance));

                    } else if (commandParts[1].equals("Bus")) {
                        bus.setEmpty(false);
                        System.out.println(bus.driving(distance));
                    }


                } else if ("Refuel".equals(currentCommand)) {
                    double liters = Double.parseDouble(commandParts[2]);
                    if (commandParts[1].equals("Car")) {
                        car.refuel(liters);
                    } else if (commandParts[1].equals("Truck")) {
                        truck.refuel(liters);
                    } else if (commandParts[1].equals("Bus")) {
                        bus.refuel(liters);
                    }
                } else if ("DriveEmpty".equals(currentCommand)) {
                    bus.setEmpty(true);
                    distance = Double.parseDouble(commandParts[2]);
                    System.out.println(bus.driving(distance));
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);


    }
}
