package models;

import handle_exception.*;
import airline.Aircraft;

public class PassengerPlane extends Aircraft {
    private int numberOfPassengers;
    
    public PassengerPlane() {
        super();
    }
    
    public PassengerPlane(String aircraftModel, int maxCapacity, double currentFuelLevel, int numberOfPassengers) {
        super(aircraftModel, maxCapacity, currentFuelLevel);
        this.numberOfPassengers = numberOfPassengers;
    }
    
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    
    public void showAvailableSeats() {
        int availableSeats = getMaxCapacity() - numberOfPassengers;
        System.out.println("Available Seats: " + availableSeats);
    }
    
    public void bookSeats(int seats) throws SeatsUnavailableException {
        int availableSeats = this.getMaxCapacity() - numberOfPassengers;

        if (seats <= availableSeats) {
            numberOfPassengers += seats;
            System.out.println(seats + " seats successfully booked.");
        } else {
            throw new SeatsUnavailableException("Not enough seats available. Requested: " 
                                                + seats + ", Available: " + availableSeats);
        }
        System.out.println("Seats available after booking: " + (this.getMaxCapacity() - numberOfPassengers));
    }

    public double calculateFuelNeeds() {
        double fuelPerPassenger = 5.0; 
        return numberOfPassengers * fuelPerPassenger + 1000; // Base fuel + fuel per passenger
    }
    
    @Override
    public String toString() {
        return "PassengerPlane {" +
                "\n  Aircraft Model='" + getAircraftModel() + '\'' +
                "\n  Max Passenger Capacity=" + getMaxCapacity() +
                "\n  Current Fuel Level=" + getCurrentFuelLevel() +
                "\n  Number of Passengers=" + numberOfPassengers +
                "\n}";
    }

}
