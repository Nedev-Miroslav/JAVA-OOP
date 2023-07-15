package W05ExercisesPolymorphism.P02VehiclesExtension;

public class Truck extends Vehicle {
    public static final double AC_MORE_FUEL_CONSUMPTION = 1.6;
    public static final double FUEL_AFTER_LOOSE = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + AC_MORE_FUEL_CONSUMPTION);
    }


    @Override
    public void refuel(double addedFuel) {
        super.refuel(addedFuel * FUEL_AFTER_LOOSE);
    }

}
