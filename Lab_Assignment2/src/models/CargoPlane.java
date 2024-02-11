package models;

import airline.*;
import handle_exception.*;

public class CargoPlane extends Aircraft {
    private double cargoCapacity; // Maximum cargo capacity in kilograms.
    private double currentCargoLoad; // Current cargo load in kilograms.
    
    public CargoPlane() {
        super();
    }
    
    public CargoPlane(String aircraftModel, int maxCapacity, double currentFuelLevel, double cargoCapacity, double currentCargoLoad) {
        super(aircraftModel, maxCapacity, currentFuelLevel);
        this.cargoCapacity = cargoCapacity;
        this.currentCargoLoad = currentCargoLoad;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double getCurrentCargoLoad() {
        return currentCargoLoad;
    }
    
    public double getAvailableCargoCapacity() {
        return cargoCapacity - currentCargoLoad;
    }
    
    public double calculateFuelNeeds() {
        double fuelPerKG = 2.5;
        return currentCargoLoad * fuelPerKG + 500; // fuelPerKG * amountOfCargo + baseFuel
    }
    
    public void loadCargo(double weight) throws CargoOverloadException {
        if (currentCargoLoad + weight > cargoCapacity) {
            throw new CargoOverloadException("Can't load the cargo! It exceeds the limit");
        } else {
            currentCargoLoad += weight;
        }
    }
    
    @Override
    public String toString() {
        return "CargoPlane {" + "\n" +
               "  Aircraft Model='" + getAircraftModel() + '\'' + "\n" +
               "  Max Crew Capacity=" + getMaxCapacity() + "\n" +
               "  Current Fuel Level=" + getCurrentFuelLevel() + "\n" +
               "  Cargo Capacity=" + cargoCapacity + "\n" +
               "  Current Cargo Load=" + currentCargoLoad + "\n" +
               '}';
    }
}
