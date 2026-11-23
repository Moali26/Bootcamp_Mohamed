
package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public void saveContract(Contract contract) throws IOException {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/contracts.csv", true));

        Vehicle vehicle = contract.getVehicleSold();

        String line = "";

        if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;

            line = "SALE|" +
                    contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice() + "|" +
                    sale.getSalesTaxAmount() + "|" +
                    sale.getRecordingFee() + "|" +
                    sale.getProcessingFee() + "|" +
                    sale.getTotalPrice() + "|" +
                    (sale.isFinance() ? "YES" : "NO") + "|" +
                    sale.getMonthlyPayment();

        } else if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;

            line = "LEASE|" +
                    contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice() + "|" +
                    lease.getExpectedEndingValue() + "|" +
                    lease.getLeaseFee() + "|" +
                    lease.getTotalPrice() + "|" +
                    lease.getMonthlyPayment();
        }

        writer.write(line);
        writer.newLine();
        writer.close();
    }
}
