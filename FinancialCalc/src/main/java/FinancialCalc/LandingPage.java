package FinancialCalc;

import java.util.Scanner;

import static FinancialCalc.Calc1.calc1;
import static FinancialCalc.Calc2.calc2;
import static FinancialCalc.Calc3.calc3;

public class LandingPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which calculator would you like to use: (1-3)");
        int calcNum = scanner.nextInt();
        switch (calcNum) {
            case 1:
                calc1();
                break;
            case 2:
                calc2();
                break;
            case 3:
                calc3();
                break;
            default:
                System.out.println("Your answer is invalid.");

            scanner.close();


        }
    }
}
