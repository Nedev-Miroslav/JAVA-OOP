package W05ExercisesPolymorphism.P01Vehicles;

public class Car extends Vehicle {

    public static final double AC_MORE_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(fuelConsumption + AC_MORE_FUEL_CONSUMPTION);
    }




}
