package com.gambling.simulation;

public class GamblingSimulation {
    static final int BET = 1;             //player bets 1 for every single match
    static int accountBalance = 100;      //palyer account balance
    static int numberOfWinsDay = 0;
    static int numberOfLossDay = 0;
    static int numberOfWinsMonth = 0;
    static int numberOfLossMonth = 0;

    //temporary variable for uc-6
    static int day = 0;
    static int previousDayWin = 0;
    static int previousDayLoss = 0;
    static int luckyDAY;
    static int unluckyDay;

    //uc-2 as the gambler plays with 1 either he wins 1 or he losses 1 .
    public static void winOrLoose() {
        //we use random function to check win or losse
        int randomCheck = (int) Math.floor(Math.random() * 2);
        // by using switch case
        switch (randomCheck) {
            case 1:
                numberOfWinsMonth++;
                numberOfWinsDay++;
                accountBalance += BET;
                break;
            default:
                numberOfLossMonth++;
                numberOfLossDay++;
                accountBalance -= BET;
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
            if (accountBalance == 150 || accountBalance == 50) { //if this condition satisfied then the loop will break
                break;
            }
        }
        System.out.println("GAMBLERS ACCOUNT BALANCE IS : " + accountBalance);
        System.out.println("NUMBER OF WINS IN A DAY IS : " + numberOfWinsDay);
        System.out.println("NUMBER OF LOSSES IN A DAY IS : " + numberOfLossDay);

        luckyAndUnlucky(); //calling uc-6 here

        //we are making wins and loss in day =0 and accouunt balence =100; for a new day
        numberOfWinsDay = 0;
        numberOfLossDay = 0;
        accountBalance = 100;

    }

    //uc-4 after onr month of bet  wons and loss
    public static void gamblingForMonth() {
        for (day = 1; day <= 30; day++) {
            System.out.println("DAY:" + day + ":-");
            gambling();
        }
        System.out.println("LUCKYDAY IS : " + luckyDAY);
        System.out.println("UNLUCKYDAY IS :" + unluckyDay);
        System.out.println("TOTAL NUMBER OF WINS IN A MONTH : " + numberOfWinsMonth);
        System.out.println("TOTAL NUMBER OF LOSS IN A MONTH : " + numberOfLossMonth);
    }

    //uc-6 luckyday and unlucky day
    public static void luckyAndUnlucky() {
        if (previousDayWin < numberOfWinsDay) {           //finding day max wins
            previousDayWin = numberOfWinsDay;
            luckyDAY = day;
        }
        if (previousDayLoss < numberOfLossDay) {          //finding day max loss
            previousDayLoss = numberOfLossDay;
            unluckyDay = day;
        }
    }

    public static void main(String[] args) {
        //displaying welcome message
        System.out.println("WELCOME TO GAMBLING SIMULATION PROGRAM");
        gamblingForMonth();
    }

}
