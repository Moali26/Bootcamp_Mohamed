package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;


    }

    @Override
    public BigDecimal getValue() {

        int age = LocalDate.now().getYear() - year;
        BigDecimal value;

        if (age <= 3) {
            BigDecimal depreciation = new BigDecimal("0.03").multiply(BigDecimal.valueOf(age));
            value = getOriginalCost().multiply(BigDecimal.ONE.subtract(depreciation));
        } else if (age <= 6) {
            BigDecimal depreciation = new BigDecimal("0.06").multiply(BigDecimal.valueOf(age));
            value = getOriginalCost().multiply(BigDecimal.ONE.subtract(depreciation));

        } else if (age <= 10) {
            BigDecimal depreciation = new BigDecimal("0.08").multiply(BigDecimal.valueOf(age));
            value = getOriginalCost().multiply(BigDecimal.ONE.subtract(depreciation));
        } else {
            value = new BigDecimal("1000.00");
        }

        if (odometer > 100000 &&
                !makeModel.toLowerCase().contains("honda") &&
                !makeModel.toLowerCase().contains("toyota")) {

            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }


}
