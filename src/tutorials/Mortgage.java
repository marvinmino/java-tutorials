package tutorials;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Principal: ");
            double total = scanner.nextDouble();
            while (total < 1000 || total > 1_000_000){
                System.out.println("Please enter a number between 1.000 and 1.000.000");
                System.out.print("Principal: ");
                total = scanner.nextDouble();
            }

            System.out.print("Annual Interest Rate: ");
            float interest = scanner.nextFloat();
            while (interest <= 0 || interest > 30){
                System.out.println("Please enter a number between 0 and 30");
                System.out.print("Annual Interest Rate: ");
                interest = scanner.nextFloat();
            }

            System.out.print("Period(Years): ");
            byte years = scanner.nextByte();
            while (years <= 0 || years > 30){
                System.out.println("Please enter a number between 0 and 30");
                System.out.print("Period(Years): ");
                years = scanner.nextByte();
            }

            System.out.printf("Total Mortgage: " + calculate(total, interest, years));
        }catch (Exception e) {
            System.out.println("There was an error with the program please retry");
            main(args);
        }
    }

    private static String calculate(double total,float interest ,byte years){
        //calculate the monthly interest rate which has been input as a percentage
        float monthlyRate = (interest/12)/100;
        //get the total number of months
        int months = years * 12;

        double mortgage = total
                * ((monthlyRate * Math.pow(1+monthlyRate, months)
                / (Math.pow(1+monthlyRate, months) -1 )));

        String formattedCurrency = NumberFormat.getCurrencyInstance().format(mortgage);
        return formattedCurrency;
    }
}
