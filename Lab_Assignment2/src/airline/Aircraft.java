package airline;
import handle_exception.*;

public abstract class Aircraft {
    private String aircraftModel;
    private int maxCapacity;
    private double currentFuelLevel;
    
    public Aircraft() {
    
    }

    public Aircraft(String aircraftModel, int maxCapacity, double currentFuelLevel) {
        this.aircraftModel = aircraftModel;
        this.maxCapacity = maxCapacity;
        this.currentFuelLevel = currentFuelLevel;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }
    
    
    public abstract double calculateFuelNeeds(); 
    
    public void refuel(int fuelAmount) throws FuelCapacityExceededException {
        if (currentFuelLevel + fuelAmount > maxCapacity) {
            throw new FuelCapacityExceededException("Fuel capacity exceeds!\nCurrent fuel level: " + currentFuelLevel + "\nRefueling " + fuelAmount + " is not possible");
        } else {
            currentFuelLevel += fuelAmount;
        }
    }
}
