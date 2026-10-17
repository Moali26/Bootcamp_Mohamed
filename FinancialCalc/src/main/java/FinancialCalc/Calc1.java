package FinancialCalc;

import java.util.Scanner;

public class Calc1 {
    public static void calc1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in calc 1");

        System.out.println("----Calculator 1----");

        System.out.println("How much is monthly Principal (Round to the nearest dollar)");
        double p = scanner.nextDouble();

        System.out.println("How much is your Annual Interest Rate");
        double r = scanner.nextDouble();

        System.out.println("How long is your Loan Term?(In Years)");
        double y = scanner.nextDouble();


        double monthlyRate = r/12/100;
        double numberOfPayments = y*12.0;

        double monthlyPayments =p * (monthlyRate * Math.pow(1+monthlyRate,numberOfPayments))/ (Math.pow(1+monthlyRate,numberOfPayments)-1);

        double totalInterest= (monthlyPayments * numberOfPayments) -p;

        System.out.printf("Monthly Payment:%.2f%n",monthlyPayments);
        System.out.printf("Total Interest Paid:%.2f%n",totalInterest);

        scanner.close();





//




















    }
}


//principal = int
//aInterestRate = double
//loanTerm= int
//numMonthlyPayments= int
//mInterestrate = double