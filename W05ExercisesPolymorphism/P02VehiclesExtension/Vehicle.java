package W05ExercisesPolymorphism.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    public String driving(double distance) {
        double neededFuel = this.fuelConsumption * distance;
        DecimalFormat df = new DecimalFormat("#.##");
        String resul = String.format("%s needs refueling", this.getClass().getSimpleName());
        if (this.fuelQuantity >= neededFuel) {
            resul = String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
            this.fuelQuantity -= neededFuel;
        }
        return resul;
    }

    public void refuel(double addedFuel) {
        if (addedFuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newFuelQuantity = addedFuel + this.fuelQuantity;

        if (newFuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += addedFuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
