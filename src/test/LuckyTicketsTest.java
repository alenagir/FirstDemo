package test;

import models.TicketsPack;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.LuckyTickets;

import static org.junit.jupiter.api.Assertions.*;

class LuckyTicketsTest {
    TicketsPack ticketsPack=new TicketsPack();
    LuckyTickets luckyTickets=new LuckyTickets();

                //With ValueSource

    @DisplayName("Symmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void countSymmetricNumberTickets(Integer integer) throws VariableEnterException{
        ticketsPack.setMinNumber(integer);
        ticketsPack.setMaxNumber(integer);
        assertEquals(luckyTickets.getLuckyTicketsCount1(), luckyTickets.getLuckyTicketsCount2());
    }

    @DisplayName("Symmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void trueCheckTicket_1_SymmetricSource(Integer integer) throws VariableEnterException {
        assertTrue(luckyTickets.checkTicket1(integer));
        assertTrue(luckyTickets.checkTicket2(integer));
    }


    @DisplayName("Asymmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {1,123456,999000,990999})
    void falseCheckTicket_1_AsymmetricSource(Integer integer) throws VariableEnterException {
        assertFalse(luckyTickets.checkTicket1(integer));
        assertFalse(luckyTickets.checkTicket2(integer));
    }


    @DisplayName("Asymmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void falseCheckTicket_1_2_AsymmetricSource(Integer integer) {
        assertFalse(luckyTickets.checkTicket1(integer));
        assertFalse(luckyTickets.checkTicket2(integer));
    }


    // @CsvSource()
    
    @DisplayName("Diapason 0-999999 gives 55252 'lucky' tickets")
    @ParameterizedTest
    @CsvSource({"0,999999"})
    void countAllDiapasonTicketsFrom_0_Method_1(Integer int1, Integer int2) throws VariableEnterException{
        ticketsPack.setMinNumber(int1);
        ticketsPack.setMaxNumber(int2);
        luckyTickets.countTickets(ticketsPack);
        assertEquals(55252, luckyTickets.getLuckyTicketsCount1());
    }

    @DisplayName("Diapason 0-999999 gives 55252 'lucky' tickets")
    @ParameterizedTest
    @CsvSource({"0,999999"})
    void countAllDiapasonTicketsFrom_0_Method_2(Integer int1, Integer int2) throws VariableEnterException{
        ticketsPack.setMinNumber(int1);
        ticketsPack.setMaxNumber(int2);
        luckyTickets.countTickets(ticketsPack);
        assertEquals(55252, luckyTickets.getLuckyTicketsCount2());
    }

    @DisplayName("Count in diapason gives a message about 'luckier' method")
    @ParameterizedTest
    @CsvSource({"101011,101020"})
    void countAllDiapasonWithResultMessageFirstLucky(Integer int1, Integer int2) throws VariableEnterException{
        ticketsPack.setMinNumber(int1);
        ticketsPack.setMaxNumber(int2);

        String actual =luckyTickets.countTickets(ticketsPack);

        int luckyTicketsCount1=luckyTickets.getLuckyTicketsCount1();
        int luckyTicketsCount2=luckyTickets.getLuckyTicketsCount2();

        String expected="Lucky tickets method 1: " + luckyTicketsCount1+
                "\nLucky tickets method 2: " + luckyTicketsCount2+
                "\nMethod 1 is luckier!";

        assertEquals(expected, actual);
    }

    @DisplayName("Count in diapason gives a message about 'luckier' method")
    @ParameterizedTest
    @CsvSource({"0,999999"})
    void countAllDiapasonWithResultMessageBothLucky(Integer int1, Integer int2) throws VariableEnterException{
        ticketsPack.setMinNumber(int1);
        ticketsPack.setMaxNumber(int2);

        String actual =luckyTickets.countTickets(ticketsPack);

        int luckyTicketsCount1=luckyTickets.getLuckyTicketsCount1();
        int luckyTicketsCount2=luckyTickets.getLuckyTicketsCount2();

        String expected="Lucky tickets method 1: " + luckyTicketsCount1 +
                "\nLucky tickets method 2: " + luckyTicketsCount2 +
                "\nBoth lucky!";

        assertEquals(expected, actual);
    }




}