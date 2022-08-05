package digital.lights.firstweek.monday.second;

import java.util.Vector;

public class Garage {
    Vector<Vehicle> vehicles;

    public Garage() {
        vehicles = new Vector<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        for (var i : vehicles) {
            if (i.equals(vehicle))
                return false;
        }
        vehicles.add(vehicle);
        return true;
    }


    public double getAverageFuelConsumption() {
        double fuelConsumption = 0;
        for (var i : vehicles) {
            fuelConsumption += i.fuelConsumption();
        }
        return fuelConsumption / vehicles.size();
    }
}
