
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public BigDecimal getExpectedEndingValue() {
        return getVehicleSold().getPrice()
                .multiply(new BigDecimal("0.50"));
    }

    public BigDecimal getLeaseFee() {
        return getVehicleSold().getPrice()
                .multiply(new BigDecimal("0.07"));
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndingValue().add(getLeaseFee());
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        double annualRate = 0.04;
        int months = 36;

        double monthlyRate = annualRate / 12;
        double total = getTotalPrice().doubleValue();

        double payment = total * monthlyRate /
                (1 - Math.pow(1 + monthlyRate, -months));

        return BigDecimal.valueOf(payment)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
