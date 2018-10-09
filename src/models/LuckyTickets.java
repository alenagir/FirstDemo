package models;

import service.Scanned;

public class LuckyTickets {
    private static final int MAX_NUMBER = 999999;
    private int min=0;
    private int max=0;

    public void calcTickets() {
        try {
            System.out.println("Enter MIN ticket number:");
             min = Scanned.scanToInteger();
            System.out.println("Enter MAX ticket number:");
             max = Scanned.scanToInteger();
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        if (min < 0) min = 0;
        if (max > MAX_NUMBER) {

            System.out.println("Max value has more then 6 digits and will be reduced to 999999");
            max = MAX_NUMBER;
        }

        System.out.printf("Ticket number range: "+"%06d - %06d"+"\n", min, max);

        int luckyTicketsCount1 = 0;
        int luckyTicketsCount2 = 0;
        for (int number = min; number <= max; number++) {
            if (this.checkTicket1(number))
                luckyTicketsCount1++;

            if (this.checkTicket2(number))
                luckyTicketsCount2++;
        }

        System.out.println("Lucky tickets method 1: " + luckyTicketsCount1);
        System.out.println("Lucky tickets method 2: " + luckyTicketsCount2);
        if(luckyTicketsCount1>luckyTicketsCount2){
            System.out.println("Method 1 is luckier!");
        }
        if(luckyTicketsCount1<luckyTicketsCount2){
            System.out.println("Method 2 is luckier!");
        }
    }



    private int getNumerals(int number, int index)  {
        return number % ((int)Math.pow(10, index)) / ((int)Math.pow(10, index - 1));
    }


    private boolean checkTicket1(int number) {
        int sum1 = 0;
        int sum2 = 0;
        for (int index = 1; index <= 6; index++) {
            if (index <= 3)
                sum1 = sum1 + getNumerals(number, index);
            else
                sum2 = sum2 + getNumerals(number, index);
        }
        return  sum1 == sum2;
    }

    private boolean checkTicket2(int number) {
        int sum1 = 0;
        int sum2 = 0;

        for (int index = 1; index <= 6; index++) {
            if (index % 2 == 0)
                sum1 = sum1 + getNumerals(number, index);
            else
                sum2 = sum2 + getNumerals(number, index);
        }
        return  sum1 == sum2;
    }

}
