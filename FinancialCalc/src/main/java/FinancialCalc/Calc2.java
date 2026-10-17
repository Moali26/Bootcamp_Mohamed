package FinancialCalc;

import java.util.Scanner;

public class Calc2 {
    public static void calc2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in calc 2");


            System.out.println("---- Calculator 2----");

            System.out.println("Initial Deposit");
            double p = scanner.nextDouble();

            System.out.println("Annual Interest");
            double r = scanner.nextDouble();

            System.out.println("Years");
            double t = scanner.nextDouble();

            double dailyRate = r/365/100;
            double dailyCompunding = t*365;

            double futureValue = p * Math.pow(1+ dailyRate,dailyCompunding);
            double totalInterestEarned= futureValue-p;

        System.out.printf("totalInterestEarned:%.2f%n",totalInterestEarned);
            System.out.printf("futureValue:%.2f%n",futureValue);


            scanner.close();
        }
}

 // FV = P(1 + r/n)^(n*t)