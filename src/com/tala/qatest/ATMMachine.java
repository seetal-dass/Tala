package com.tala.qatest;

import java.util.Scanner;

/**
 * Created by: Seetal Dass
 * Date:       04/05/2017
 * Class:      Perform the ATM functionality.
 */
public class ATMMachine {

    //CLASS VARIABLES
    private static Scanner input = new Scanner(System.in);
    private static Double balance = 0.0;
    private static Double collectiveDepositAmount = 0.0;
    private static Double collectiveWithdrawAmount = 0.0;
    private static int depositTransaction = 1;
    private static int withDrawTransaction = 1;

    //CONSTANTS
    private static Double MAXDEPOSITPERDAY = 150000.0;
    private static Double MAXWITHDRAWPERDAY = 50000.0;


    public static void main(String[] args) {

        //VARIABLES
        Boolean flag = Boolean.TRUE;

        do {
            int option = menuOptions();
            switch (option) {
                case 1:
                    balance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    flag = quitATM();
                    break;
                default:
                    System.out.println("********* CASE NOT IMPLEMENTED. ********* ");
            }
        } while (flag);
        if (!flag) {
            System.exit(0);
        }
    }


    /*#################################################################
    Function Name:           menuOptions
    Function Arguments:      N/A
    Function Description:    Displays menu for the program
    Function Return Values:  N/A
    #################################################################*/
    private static int menuOptions() {

        System.out.println("\n       **********************  TALA ATM  **********************  \n");
        System.out.println("Select one of the above options: ");
        System.out.println("1. CHECK BALANCE ");
        System.out.println("2. DEPOSIT MONEY ");
        System.out.println("3. WITHDRAW MONEY ");
        System.out.println("4. QUIT ATM ");
        System.out.println("######   CURRENT BALANCE: " + balance + " KES   ######");
        return scanInteger();
    }


    /*#################################################################
    Function Name:           scanInteger
    Function Arguments:      N/A
    Function Description:    Reads input from console
    Function Return Va ues:  int: returns the console input of type int
    #################################################################*/
    private static int scanInteger() {

        //VARIABLES
        int option;

        do {
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter options between 1 - 4.");
                input.next();
            }
            option = input.nextInt();
            if (option < 0 || option > 5) {
                System.out.println("Invalid input. Please enter options between 1 - 4.");
            }
        } while (option < 0 || option > 5);
        return option;
    }


    /*#################################################################
   Function Name:           scanDouble
   Function Arguments:      N/A
   Function Description:    Reads input from console
   Function Return Values:  int: returns the console input of type double
   #################################################################*/
    private static double scanDouble() {

        //VARIABLES
        Double value;

        do {
            while (!input.hasNextDouble()) {
                System.out.println("ERROR: Please enter a valid value.");
                input.next();
            }
            value = input.nextDouble();
            if(value <= 0){
                System.out.println("ERROR: Please enter a valid value.");
            }
        } while (value <= 0.0);
        return value;
    }

    /*#################################################################
    Function Name:          balance
    Function Arguments:     N/A
    Function Description:   Prints the current balance
    Function Return Values:  N/A
    #################################################################*/
    private static void balance() {

        System.out.println("Current Balance:" + balance);
    }

    /*#################################################################
    Function Name:           deposit
    Function Arguments:      N/A
    Function Description:    Performs the deposit from ATM functionality
    Function Return Values:  N/A
    #################################################################*/
    private static void deposit() {

        if (depositTransaction < 5) {
            System.out.println("      #####   DEPOSIT   ######");
            System.out.println("CURRENT BALANCE: " + balance + " KES");
            System.out.println("MAXIMUM DEPOSIT PER TRANSACTION: 40,000 KES. \n How much do you want to deposit?");
            Double depositAmount = scanDouble();
            if (depositAmount > 40000) { //Error msg if deposit amount is > 40,000
                    System.out.println("Maximum deposit per transaction: 40,000 KES");
            } else if (collectiveDepositAmount + depositAmount > MAXDEPOSITPERDAY) { //Error message if maxdeposit per day has reached
                System.out.println("Will pass maximum deposit limit of 150,000 KES per day. Can only deposit: " +
                        (MAXDEPOSITPERDAY - collectiveDepositAmount));
            } else if (depositAmount <= 40000 && (collectiveDepositAmount <= MAXDEPOSITPERDAY)) { //deposit if all conditions satisfy
                balance += depositAmount;
                collectiveDepositAmount += depositAmount;
                depositTransaction += 1;
                System.out.println("Deposit successful. Current Balance: " + balance + " KES");
            }
        } else {
            System.out.println("Maximum frequency of deposit transactions reached for today. Try again tomorrow.");
        }
    }

    /*#################################################################
    Function Name:           withdraw
    Function Arguments:      N/A
    Function Description:    Performs the withdraw from ATM functionality
    Function Return Values:  N/A
    #################################################################*/
    private static void withdraw() {

        if (withDrawTransaction < 4) {
            System.out.println("     #####   WITHDRAW   ######");
            System.out.println("CURRENT BALANCE: " + balance  + " KES");
            System.out.println("MAXIMUM WITHDRAW PER TRANSACTION: 20000 KES.\n How much do you want to withdraw?");
            Double withDrawAmount = scanDouble();
            if (balance < withDrawAmount) { //Error msg if withdraw amount is greater than balance
                System.out.println("Insufficient Balance.");
            } else {
                if (collectiveWithdrawAmount + withDrawAmount > MAXWITHDRAWPERDAY) { //Error msg if max withdraw per day has reached
                    System.out.println("Will pass maximum withdraw limit of 50,000 KES per day. Can only withdraw: " +
                            (MAXWITHDRAWPERDAY - collectiveWithdrawAmount) + " KES.");
                } else if (withDrawAmount > 20000) { //Error msg if withdrawing more than max withdrawal limit per transaction
                    System.out.println("Maximum withdraw amount per transaction: 20,000 KES");
                } else if (withDrawAmount <= 20000 && withDrawAmount <= balance) { //withdraw if all conditions satisfy
                    balance -= withDrawAmount;
                    withDrawTransaction += 1;
                    collectiveWithdrawAmount += withDrawAmount;
                    System.out.println("Withdraw successful. Current Balance: " + balance + " KES");
                }
            }
        } else {
            System.out.println("Maximum frequency of withdraw transactions reached for today. Try again tomorrow.");
        }
    }

    /*#################################################################
    Function Name:          quitATM
    Function Arguments:     N/A
    Function Description:   Performs the withdraw from ATM functionality
    Function Return Values: Boolean: returns TRUE if quitATM else returns
                            FALSE.
    #################################################################*/
    private static Boolean quitATM() {

        Boolean flag = Boolean.TRUE;
        System.out.println("Are you sure you want to exit: (Y/N)");
        String exitValue = input.next();
        if (exitValue.equals("y") || exitValue.equals("Y")) {
            System.out.println("GOODBYE!! HAVE A NICE DAY.");
            flag = Boolean.FALSE;
        }
        return flag;
    }
}
