
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract {

    private boolean finance;

    public SalesContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold,
                         boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public BigDecimal getSalesTaxAmount() {
        return getVehicleSold().getPrice()
                .multiply(new BigDecimal("0.05"));
    }

    public BigDecimal getRecordingFee() {
        return new BigDecimal("100.00");
    }

    public BigDecimal getProcessingFee() {
        if (getVehicleSold().getPrice()
                .compareTo(new BigDecimal("10000")) < 0) {
            return new BigDecimal("295.00");
        } else {
            return new BigDecimal("495.00");
        }
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getVehicleSold().getPrice()
                .add(getSalesTaxAmount())
                .add(getRecordingFee())
                .add(getProcessingFee())
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (!finance) {
            return BigDecimal.ZERO.setScale(2);
        }

        BigDecimal price = getVehicleSold().getPrice();

        double annualRate;
        int months;

        if (price.compareTo(new BigDecimal("10000")) >= 0) {
            annualRate = 0.0425;
            months = 48;
        } else {
            annualRate = 0.0525;
            months = 24;
        }

        double monthlyRate = annualRate / 12;
        double total = getTotalPrice().doubleValue();

        double payment = total * monthlyRate /
                (1 - Math.pow(1 + monthlyRate, -months));

        return BigDecimal.valueOf(payment)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
