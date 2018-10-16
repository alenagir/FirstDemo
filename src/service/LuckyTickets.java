package service;

import models.TicketsPack;

public class LuckyTickets {

    String ticketsAnswer;
    private int luckyTicketsCount1 = 0;
    private int luckyTicketsCount2 = 0;

    public int getLuckyTicketsCount1() {
        return luckyTicketsCount1;
    }

    public int getLuckyTicketsCount2() {
        return luckyTicketsCount2;
    }

    public String countTickets(TicketsPack ticketsPack)  {
        luckyTicketsCount1 = 0;
        luckyTicketsCount2 = 0;
        for (int number = ticketsPack.getMinNumber(); number <= ticketsPack.getMaxNumber(); number++) {
            if (checkTicket1(number)) {
                luckyTicketsCount1++;
            }
            if (checkTicket2(number)){
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

        //Gets each numeral in ticket number
        private int getNumerals(int number, int index)  {
            return number % (int)Math.pow(10, index) / (int)Math.pow(10, index - 1);
        }

        public boolean checkTicket1(int number) {

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

        public boolean checkTicket2(int number) {

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

