package org.example;



import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private DealershipFileManager fileManager = new DealershipFileManager();
    private Scanner scanner = new Scanner(System.in);

    public void display() throws IOException {
        init();
        boolean running = true;

        while (running) {
            System.out.println("\n==== CAR DEALERSHIP ====");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void init() throws IOException {
        dealership = fileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println("--------------------------");
            System.out.println("VIN: " + vehicle.getVin());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Mileage: " + vehicle.getOdometer());
            System.out.println("Price: $" + vehicle.getPrice());
        }

        System.out.println("--------------------------");
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());

        for (Vehicle existing : dealership.getAllVehicles()) {
            if (existing.getVin() == vin) {
                System.out.println("A vehicle with that VIN already exists.");
                return;
            }
        }

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        if (vin < 0 || year < 0 || odometer < 0
                || price.compareTo(BigDecimal.ZERO) < 0
                || make.isEmpty() || model.isEmpty()
                || vehicleType.isEmpty() || color.isEmpty()
                || make.contains("|") || model.contains("|")
                || vehicleType.contains("|") || color.contains("|")) {
            System.out.println("Invalid vehicle information.");
            return;
        }

        Vehicle vehicle = new Vehicle(
                vin, year, make, model, vehicleType,
                color, odometer, price
        );

        dealership.addVehicle(vehicle);

        try {
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle added and saved.");
        } catch (IOException e) {
            dealership.removeVehicle(vehicle);
            System.out.println("Error saving vehicle: " + e.getMessage());
        }
    }

    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        dealership.removeVehicle(vehicleToRemove);

        try {
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed and saved.");
        } catch (IOException e) {
            dealership.addVehicle(vehicleToRemove);
            System.out.println("Error saving removal: " + e.getMessage());
        }
    }
}
