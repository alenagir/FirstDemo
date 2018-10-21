package test;

import models.TicketsPack;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.LuckyTickets;

import static org.junit.jupiter.api.Assertions.*;

class LuckyTicketsTest {
    TicketsPack ticketsPack=new TicketsPack();
    LuckyTickets luckyTickets=new LuckyTickets();


    @Tag("baseMethod")
    @DisplayName("Soft assert: Symmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void trueCheckTicket_1_2_SymmetricSource(Integer integer) throws VariableEnterException {
        Integer digits[]=luckyTickets.getNumerals(integer);
        assertAll("assertTrue",
                () ->  assertTrue(luckyTickets.checkTicket1(digits)),
                () -> assertTrue(luckyTickets.checkTicket2(digits))
        );
    }

    @Tag("baseMethod")
    @DisplayName("Soft assert: Asymmetric numbers")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,123456,999000,990999})
    void falseCheckTicket_1_2_AsymmetricSource(Integer integer) throws VariableEnterException {
        Integer digits[]=luckyTickets.getNumerals(integer);
        assertAll("assertFalse",
                () ->  assertFalse(luckyTickets.checkTicket1(digits)),
                () -> assertFalse(luckyTickets.checkTicket2(digits))
        );
    }


    @Tag("intermediateVariable")
    @DisplayName("For 1: 101011 and 101020. For 2: 101013 and 101024")
    @ParameterizedTest
    @CsvSource({"101011,101024"})
    void luckyTicketCount_1_2(Integer min, Integer max) throws VariableEnterException{
        ticketsPack.setMinNumber(min);
        ticketsPack.setMaxNumber(max);
        luckyTickets.countTickets(ticketsPack);

        assertEquals(2, luckyTickets.getLuckyTicketsCount1());
        assertEquals(2, luckyTickets.getLuckyTicketsCount2());
    }


    @Tag("intermediateVariable")
    @DisplayName("Diapason 0-999999 gives 55252 'lucky' tickets")
    @ParameterizedTest
    @CsvSource({"0,999999"})
    void countAllDiapasonTicketsMethod_1_2(Integer int1, Integer int2) throws VariableEnterException{
        ticketsPack.setMinNumber(int1);
        ticketsPack.setMaxNumber(int2);
        luckyTickets.countTickets(ticketsPack);
        assertEquals(55252, luckyTickets.getLuckyTicketsCount1());
        assertEquals(55252, luckyTickets.getLuckyTicketsCount2());
    }

    @Tag("finalMethod")
    @DisplayName("Count in diapason gives a message. For 1: 101011 and 101020. For 2: 101013")
    @ParameterizedTest
    @CsvSource({"101011,101020,2,1"})
    void countAllDiapasonWithResultMessageFirstLucky(Integer min, Integer max, Integer result1, Integer result2) throws VariableEnterException{
        ticketsPack.setMinNumber(min);
        ticketsPack.setMaxNumber(max);

        String actual =luckyTickets.countTickets(ticketsPack);

        int luckyTicketsCount1=result1;
        int luckyTicketsCount2=result2;

        String expected="Lucky tickets method 1: " + luckyTicketsCount1+
                "\nLucky tickets method 2: " + luckyTicketsCount2+
                "\nMethod 1 is luckier!";

        assertEquals(expected, actual);
    }

    @Tag("finalMethod")
    @DisplayName("Count in diapason gives a message about 'luckier' method")
    @ParameterizedTest
    @CsvSource({"0,999999,55252"})
    void countAllDiapasonWithResultMessageBothLucky(Integer min, Integer max, Integer result) throws VariableEnterException{
        ticketsPack.setMinNumber(min);
        ticketsPack.setMaxNumber(max);

        String actual =luckyTickets.countTickets(ticketsPack);

        int luckyTicketsCount1=result;
        int luckyTicketsCount2=result;

        String expected="Lucky tickets method 1: " + luckyTicketsCount1 +
                "\nLucky tickets method 2: " + luckyTicketsCount2 +
                "\nBoth lucky!";

        assertEquals(expected, actual);
    }




}