package com.gambling.simulation;

public class GamblingSimulation {
    static final int BET = 1;             //player bets 1 for every single match
    static int accountBalance = 100;      //palyer account balance

    //uc-2 as the gambler plays with 1 either he wins 1 or he losses 1 .
    public static void winOrLoose() {
        //we use random function to check win or losse
        int randomCheck = (int) Math.floor(Math.random() * 2);
        // by using switch case
        switch (randomCheck) {
            case 1:
                accountBalance += BET;
                System.out.println("PLAYER WON THE BET.");
                System.out.println("PLAYERS ACCOUNT BALANCE IS : " + accountBalance);
            default:
                accountBalance -= BET;
                System.out.println("PLAYER LOSSES THE BET.");
                System.out.println("PLAYERS ACCOUNT BALANCE IS : " + accountBalance);
        }
    }

    //uc-3 as the gambler wins 50 of stack would resign for the day
    public static void gambling() {
        int temporaryBalance = accountBalance;     //creating temporary balance is to hold the account balance=100;
        int fiftyPercent = (50 / 100) * temporaryBalance; //calculating fifty percent

        //we are using while loop to continue looping until we get fifty percent of stake
        while (accountBalance <= (accountBalance + fiftyPercent) ||
                accountBalance >= (accountBalance - fiftyPercent)) {
            winOrLoose();  //calling player win or loss method

            //we are using if statement to stop the loop when player gets 150 or 50
            if (accountBalance == 150 || accountBalance == 50) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        //displaying welcome message
        System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
        gambling();
    }

}
