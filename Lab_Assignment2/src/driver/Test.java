package driver;

import models.*;
import handle_exception.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CargoPlane cargoplane1 = new CargoPlane("Airbus A330-200F", 10, 5000, 8000, 4000);
        CargoPlane cargoPlane2 = new CargoPlane("Boeing 747F", 12, 6000, 9000, 5000);
        CargoPlane cargoPlane3 = new CargoPlane("Embraer KC-390", 8, 4000, 7000, 3000);
        
        PassengerPlane passengerplane1 = new PassengerPlane("Boeing 737", 150, 3000, 100);
        PassengerPlane passengerPlane2 = new PassengerPlane("Airbus A320", 200, 4000, 150);
        PassengerPlane passengerPlane3 = new PassengerPlane("Boeing 777", 300, 5000, 200);

        CargoPlane[] cargoPlanes = {cargoplane1, cargoPlane2, cargoPlane3};
        PassengerPlane[] passengerPlanes = {passengerplane1, passengerPlane2, passengerPlane3};

        int mainOption;

        do {
            System.out.println("\nSelect Aircraft Type:");
            System.out.println("1. Cargo Plane");
            System.out.println("2. Passenger Plane");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1: // Cargo Plane Operations
                    System.out.println("\nAvailable Cargo Planes:");
                    for (int i = 0; i < cargoPlanes.length; i++) {
                        System.out.println((i + 1) + ". " + cargoPlanes[i].getAircraftModel());
                    }
                    System.out.print("Enter your choice: ");
                    int cargoChoice = scanner.nextInt();
                    CargoPlane selectedCargoPlane = cargoPlanes[cargoChoice - 1];

                    int cargoOption;
                    do {
                        System.out.println("\nCargo Plane Operations:");
                        System.out.println("1. Load Cargo");
                        System.out.println("2. Refuel Aircraft");
                        System.out.println("3. Display Aircraft Info");
                        System.out.println("4. Calculate and Display Fuel Needs");
                        System.out.println("5. Show Available Cargo Capacity");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        cargoOption = scanner.nextInt();

                        try {
                            switch (cargoOption) {
                                case 1: // Load cargo
                                    System.out.print("\nEnter cargo weight to load: ");
                                    double weight = scanner.nextDouble();
                                    selectedCargoPlane.loadCargo(weight);
                                    break;
                                case 2: // Refuel Aircraft
                                    System.out.print("\nEnter fuel amount: ");
                                    int fuelAmount = scanner.nextInt();
                                    selectedCargoPlane.refuel(fuelAmount);
                                    break;
                                case 3: // Display Aircraft Info
                                    System.out.println("\nCargo Plane Info: " + selectedCargoPlane);
                                    break;
                                case 4: // Calculate and Display Fuel Needs
                                    System.out.println("\nFuel needs for current cargo load: " + selectedCargoPlane.calculateFuelNeeds());
                                    break;
                                case 5: // Show Available Cargo Capacity
                                    System.out.println("\nAvailable Cargo Capacity: " + selectedCargoPlane.getAvailableCargoCapacity());
                                    break;
                                case 6: // Back to Main Menu
                                    break;
                                default:
                                    System.out.println("\nInvalid option! Please try again.");
                            }
                        } catch (FuelCapacityExceededException | CargoOverloadException e) {
                            System.out.println("\nException occurred: " + e.getMessage());
                        }
                    } while (cargoOption != 6);
                    break;

                case 2: // Passenger Plane Operations
                    System.out.println("\nAvailable Passenger Planes:");
                    for (int i = 0; i < passengerPlanes.length; i++) {
                        System.out.println((i + 1) + ". " + passengerPlanes[i].getAircraftModel());
                    }
                    System.out.print("Enter your choice: ");
                    int passengerChoice = scanner.nextInt();
                    PassengerPlane selectedPassengerPlane = passengerPlanes[passengerChoice - 1];

                    int passengerOption;
                    do {
                        System.out.println("\nPassenger Plane Operations:");
                        System.out.println("1. Book Seats");
                        System.out.println("2. Refuel Aircraft");
                        System.out.println("3. Display Aircraft Info");
                        System.out.println("4. Calculate and Display Fuel Needs");
                        System.out.println("5. Show Available Seats");
                        System.out.println("6. Show Number of Booked Seats/Passengers");
                        System.out.println("7. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        passengerOption = scanner.nextInt();

                        try {
                            switch (passengerOption) {
                                case 1: // Book seats
                                    System.out.print("\nEnter number of seats to book: ");
                                    int seats = scanner.nextInt();
                                    selectedPassengerPlane.bookSeats(seats);
                                    break;
                                case 2: // Refuel Aircraft
                                    System.out.print("\nEnter fuel amount: ");
                                    int fuelAmount = scanner.nextInt();
                                    selectedPassengerPlane.refuel(fuelAmount);
                                    break;
                                case 3: // Display Aircraft Info
                                    System.out.println("\nPassenger Plane Info: " + selectedPassengerPlane);
                                    break;
                                case 4: // Calculate and Display Fuel Needs
                                    System.out.println("\nFuel needs for current passengers: " + selectedPassengerPlane.calculateFuelNeeds());
                                    break;
                                case 5: // Show Available Seats
                                    selectedPassengerPlane.showAvailableSeats();
                                    break;
                                case 6: // Show Number of Booked Seats/Passengers
                                    System.out.println("\nNumber of Booked Seats/Passengers: " + selectedPassengerPlane.getNumberOfPassengers());
                                    break;
                                case 7: // Back to Main Menu
                                    break;
                                default:
                                    System.out.println("\nInvalid option! Please try again.");
                            }
                        } catch (FuelCapacityExceededException | SeatsUnavailableException e) {
                            System.out.println("\nException occurred: " + e.getMessage());
                        }
                    } while (passengerOption != 7);
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (mainOption != 3);

        scanner.close();
    }
}
