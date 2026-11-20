package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {
    public Dealership getDealership() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        String[] parts = line.split("\\|");
        Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);
        while ((line = bufferedReader.readLine()) != null) {
            String[] vehicleParts = line.split("\\|");
            int vin = Integer.parseInt(vehicleParts[0]);
            int year = Integer.parseInt(vehicleParts[1]);
            String make = vehicleParts[2];
            String model = vehicleParts[3];
            String vehicleType = vehicleParts[4];
            String color = vehicleParts[5];
            int odometer = Integer.parseInt(vehicleParts[6]);
            BigDecimal price = new BigDecimal(vehicleParts[7]);
            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(vehicle);


        }
        bufferedReader.close();
        return dealership;
    }
        public void saveDealership(Dealership dealership) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/inventory.csv"))) {

                writer.write(dealership.getName() + "|" +
                        dealership.getAddress() + "|" +
                        dealership.getPhone());
                writer.newLine();

                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    writer.write(
                            vehicle.getVin() + "|" +
                                    vehicle.getYear() + "|" +
                                    vehicle.getMake() + "|" +
                                    vehicle.getModel() + "|" +
                                    vehicle.getVehicleType() + "|" +
                                    vehicle.getColor() + "|" +
                                    vehicle.getOdometer() + "|" +
                                    vehicle.getPrice().toPlainString()
                    );
                    writer.newLine();
                }
            }
        }

    }

