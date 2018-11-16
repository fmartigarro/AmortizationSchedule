import java.util.*;
import java.text.DecimalFormat;
public class Schedule {

    public static void main(String[] args) {


        //initializing variables
        double interest = 0.0;
        double monthlyInterest = 0.0;
        double principle = 0.0;
        double payment = 0.0;
        double numerator = 0.0;
        double denominator = 0.0;
        double balance = 0.0;
        int length = 0;

        //initializing a variable to format decimal numbers
        DecimalFormat money = new DecimalFormat("$0.00");

        //initializing scanner, prompting user input, and setting variables equal to the user input
        Scanner reader = new Scanner (System.in);
        System.out.print("Enter a loan amount: $");
        principle = reader.nextDouble();

        System.out.print("What is the yearly length of the loan?: ");
        length = reader.nextInt();

        System.out.print("What is the percent interest rate on the loan?: ");
        monthlyInterest = reader.nextDouble();

        //giving updated values to variables
        length = length * 12;
        monthlyInterest = monthlyInterest/100/12;

        numerator = principle * (monthlyInterest * Math.pow(1 + monthlyInterest,length));
        denominator = Math.pow(1 + monthlyInterest, length) - 1;

        payment = numerator/denominator;
        balance = principle;


        //printing Amortization Schedule
        System.out.println("Payment#	Interest	  Principle	     Balance");

        for(int i = 1; i <= length; i++) {
            interest = monthlyInterest * balance;
            principle = payment - interest;
            balance = balance - principle;

            System.out.println(i + "\t\t" + money.format(interest) + "\t\t" +
                    money.format(principle) + "\t\t" + money.format(balance));
        }

        reader.close();


    }
}