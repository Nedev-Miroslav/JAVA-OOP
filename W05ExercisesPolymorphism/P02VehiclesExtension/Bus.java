package W05ExercisesPolymorphism.P02VehiclesExtension;

public class Bus extends Vehicle{


    private static final boolean DEFAULT_IS_EMPTY = true;
    private boolean isEmpty;
    private static final double AC_MORE_FUEL_CONSUMPTION = 1.4;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + AC_MORE_FUEL_CONSUMPTION);
        this.isEmpty = DEFAULT_IS_EMPTY;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
        if (isEmpty = false){
            super.setFuelConsumption(this.getFuelConsumption());
        }
    }



    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if(!this.isEmpty){
        super.setFuelConsumption(fuelConsumption + AC_MORE_FUEL_CONSUMPTION);
    }

    }
}
