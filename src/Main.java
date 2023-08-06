/*Basic bank account class representing Encapsulation with object oriented programming.
This is a basic program simulating a simple bank account. If you use its
interactive menu, you may notice how decimal division in Java can add multiple zeros with a
minuscule number to numerical values. Java has BigDecimal class (not used in this program)
do deal with it. Also, at this time this program serves only one customer at a time. It is
a most basic example of object oriented programming.*/
//Author Daniel Magdziarz.

import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);
    public static Account account = new Account();
    public static void main(String[] args) {

        boolean quit = false;
        mainMenu();
        int menuSelection;
        while(!quit){
            System.out.print("Make Main Menu selection: ");
            boolean hasInt = keyboard.hasNextInt();
            if (hasInt){
                menuSelection = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                String wrongInput = keyboard.nextLine();
                System.out.println("\"" + wrongInput + " is a wrong input. Enter numeric value for menu selection.");
                continue;
            }

            switch(menuSelection){
                case 0 :
                    mainMenu();
                    break;
                case 1 :
                    depositFunds();
                    break;
                case 2 :
                    withdrawFunds();
                    break;
                case 3 :
                    System.out.print(String.format("Available balance: $%,.2f\n",account.getAccountBalance()));
                    break;
                case 9 :
                    quit = true;
                    System.out.println("Bye...");
                    break;
                default :
                    System.out.println("Wrong menu selection. Tray again.");

            }
        }
        keyboard.close();
    }

    public static void depositFunds(){
        double deposit;
        while(true){
            System.out.print("Enter deposit amount: $");
            deposit = inputValidation();
            if(deposit > 0){
                break;
            }
            System.out.println("Deposit cannot be less than $0. Try again.");
        }

        System.out.println("Accepted amount: $" + deposit);
        account.addAccountBalance(deposit);
        System.out.println("Deposit complete. Available balance: $" + account.getAccountBalance());
    }

    public static void withdrawFunds(){
        System.out.print("Enter the amount to withdraw: $");
        double withdraw = inputValidation();
        System.out.println("Accepted amount: " + withdraw);
        if(account.withdrawAccountBalance(withdraw)){
            System.out.println("Withdraw completed.\nRemaining balance: $" +
                    account.getAccountBalance());
        } else {
            System.out.println("Not enough funds to complete the withdraw.\nAvailable balance: $" +
                    account.getAccountBalance());
        }
    }

    private static double decimalValidation(double amount){

        int deprecatePast2DecimalPoints = (int) (amount * 100);
        double reassign2DecimalPoints = (double) deprecatePast2DecimalPoints / 100;
        return reassign2DecimalPoints;

    }

    public static double inputValidation(){
        String userInputStr;
        double userInput;
        while(true){
            userInputStr = keyboard.nextLine();

            try{
                userInput = Double.parseDouble(userInputStr);
                userInput = decimalValidation(userInput);
                return userInput;
            } catch (NumberFormatException nfe){
                System.out.println("Only numerical values are allowed here. Try again.");
            }
        }
    }

    public static void mainMenu(){
        System.out.println("\tMain Menu\n" +
                "0 -> Show Menu.\n" +
                "1 -> Deposit founds\n" +
                "2 -> Withdraw founds.\n" +
                "3 -> Show available balance.\n" +

                "9 -> Exit program.");
    }
}
