package W05ExercisesPolymorphism.P02VehiclesExtension;

public class Car extends Vehicle {

    public static final double AC_MORE_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + AC_MORE_FUEL_CONSUMPTION);
    }




}
