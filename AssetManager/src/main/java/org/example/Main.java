package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();
        House myHouse = new House("My House", "2024-06-15", new BigDecimal("250000.00"), "123 Main Street", 2, 2000, 5000);
        assets.add(myHouse);
        House vacationHome = new House("My vacation home", "2025-03-10", new BigDecimal("350000.00"), "456 Beach Road", 1, 2500, 6000);
        assets.add(vacationHome);
        Vehicle myCar = new Vehicle("My Car", "2024-01-15", new BigDecimal("25000.00"), "Toyota Camry", 2021, 45000);
        assets.add(myCar);
        Vehicle tomsTruck = new Vehicle("Toms Truck", "2022-05-20", new BigDecimal("35000.00"), "Ford F-150", 2019, 120000);
        assets.add(tomsTruck);
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.printf("Current Value: $%.2f%n", asset.getValue());
            System.out.println("--------------------------");
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());

            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());

            }
            System.out.println("---------------------");
        }
    }
}