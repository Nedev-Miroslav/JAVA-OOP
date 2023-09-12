package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VehicleRepository implements Repository<Vehicle> {


        private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    @Override
    public void add(Vehicle vehicle) {
            this.vehicles.add(vehicle);
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return this.vehicles.remove(vehicle);
    }

    @Override
    public Vehicle findByName(String name) {
        // Друг начин
        // return this.vehicles.stream()
        //                .filter(v -> v.getName().equals(name))
        //                .findFirst()
        //                .orElse(null);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().equals(name)){
                return vehicle;
            }
        }

        return null;
    }
}