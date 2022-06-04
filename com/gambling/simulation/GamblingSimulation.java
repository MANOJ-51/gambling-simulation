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

    public static void main(String[] args) {
        //displaying welcome message
        System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
        winOrLoose();
    }

}
