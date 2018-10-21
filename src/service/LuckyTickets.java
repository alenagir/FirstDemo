package service;

import models.TicketsPack;

public class LuckyTickets {

    String ticketsAnswer;
    private int luckyTicketsCount1 = 0;
    private int luckyTicketsCount2 = 0;
    Integer digits[]=new Integer[6];

    public int getLuckyTicketsCount1() {
        return luckyTicketsCount1;
    }

    public int getLuckyTicketsCount2() {
        return luckyTicketsCount2;
    }

    //Method invoked from Main
    public String countTickets(TicketsPack ticketsPack)  {
        luckyTicketsCount1 = 0;
        luckyTicketsCount2 = 0;

        //Sequential increase in ticket number:
        for (int number = ticketsPack.getMinNumber(); number <= ticketsPack.getMaxNumber(); number++) {

            digits=getNumerals(number);//Returns the array of numerals in the ticket number

            if (checkTicket1(digits)) {
                luckyTicketsCount1++;
            }
            if (checkTicket2(digits)){
                luckyTicketsCount2++;
            }
        }

        if(luckyTicketsCount1>luckyTicketsCount2){
            ticketsAnswer="Lucky tickets method 1: " + luckyTicketsCount1+
                    "\nLucky tickets method 2: " + luckyTicketsCount2+
                    "\nMethod 1 is luckier!";
        }
        if(luckyTicketsCount1<luckyTicketsCount2){
            ticketsAnswer="Lucky tickets method 1: " + luckyTicketsCount1+
                    "\nLucky tickets method 2: " + luckyTicketsCount2+
                    "\nMethod 2 is luckier!";
        }
        if(luckyTicketsCount1==luckyTicketsCount2) {
            ticketsAnswer = "Lucky tickets method 1: " + luckyTicketsCount1 +
                    "\nLucky tickets method 2: " + luckyTicketsCount2 +
                    "\nBoth lucky!";
        }
        return ticketsAnswer;
    }

        //Returns the array of numerals in the ticket number
        public Integer[] getNumerals(int number)  {
            for(int i=6;i>0;i--){
                digits[i-1]=number % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1);
            }
            return digits;
        }

        //Simple method count
        public boolean checkTicket1(Integer [] digits) {

            int sum1 = 0;
            int sum2 = 0;
            for (int index = 0; index < 6; index++) {
                if (index <= 2)
                    sum1 = sum1 + digits[index];
                else
                    sum2 = sum2 + digits[index];
            }
            return  sum1 == sum2;
        }

        //Complicated method count
        public boolean checkTicket2(Integer [] digits) {

            int sum1 = 0;
            int sum2 = 0;

            for (int index = 0; index < 6; index++) {
                if (index % 2 == 0)
                    sum1 = sum1 + digits[index];
                else
                    sum2 = sum2 + digits[index];
            }
            return  sum1 == sum2;
        }

}

