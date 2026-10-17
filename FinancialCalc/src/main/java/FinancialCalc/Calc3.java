package FinancialCalc;

import java.util.Scanner;

public class Calc3 {
    public static void calc3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in calc 3");


        System.out.println("---- Calculator 3----");

        System.out.println("Payment Amount");
        double p = scanner.nextDouble();

        System.out.println("Interest rate");
        double r = scanner.nextDouble();

        System.out.println("Years");
        double t = scanner.nextDouble();

        double totalMonthlyPayment = t*12;
        double monthlyInterestRate = r/12/100;

        double presentValue = p *((1-(Math.pow(1+monthlyInterestRate,-totalMonthlyPayment)))/monthlyInterestRate);


        System.out.printf("presentValue:%.2f%n",presentValue);

        scanner.close();

    }
}
