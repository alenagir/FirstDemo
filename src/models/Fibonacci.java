package models;
import service.Printable;
import service.Scanned;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Fibonacci {
    private static long range []={0,1};
    private static String userAnswer;


    public static void userDialog() {
        //First setting borders
    try {
        do {
            System.out.println("To output by range type 1\nTo output by length type 2\n" +
                    "To exit press any key\nEnter:");

            String choice = Scanned.scanToString();

            if (choice.equals("1")) {

                System.out.println("Enter MIN border of the range:");
                range[0] = Scanned.scanToLong();
                System.out.println("Enter MAX border of the range:");
                range[1] = Scanned.scanToLong();
                if (range[1] < range[0]) {
                    long tmp=range[1];
                    range[1] = range[0];
                    range[0]=tmp;
                }

            }
            if (choice.equals("2")) {
                System.out.println("Enter number length:");
                long length = Scanned.scanToInteger();
                range[0] = (long) Math.pow(10, length - 1);
                range[1] = (long) Math.pow(10, length) - 1;
                if (range[0] == 1) {
                    range[0] = 0;
                }
            }
            if (!choice.equals("1") && (!choice.equals("2"))) {
                Printable.userTerminated();
                return;
            }


            System.out.printf("\nRange: %d - %d\n\n", range[0], range[1]);

            //Calling the method for fibonacci series print
            calcFibonacci();
            Printable.continueQuestion();
            userAnswer = Scanned.scanToString();
            if (userAnswer.equals("no") || userAnswer.equals("n")) {
                Printable.userTerminated();
                return;
            }
        } while ((userAnswer.equals("yes") || userAnswer.equals("y")));

        }catch (NumberFormatException e){
        System.out.println(e.getMessage());
    }
    }

    public static void calcFibonacci(){
        if (range[0] == 0) {
            System.out.print("F1 = 0  ");
            System.out.print("F2 = 1  ");
        }
        if (range[0] == 1){
            System.out.print("F2 = 1  ");
        }
        long fib1 = 0; //F[n-2]
        long fib2 = 1; //F[n-1]
        long fibSum = 1;// F[n]

        int n = 2;

        while (fibSum <= range[1])
        {
            n++;
            fibSum = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibSum;

            if (fibSum >= range[0] && fibSum <= range[1])
                System.out.printf("F%d = %d  ", n, fibSum);
        }

    }

}
