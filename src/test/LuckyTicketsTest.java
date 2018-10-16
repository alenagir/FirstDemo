package test;

import models.TicketsPack;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.LuckyTickets;

import static org.junit.jupiter.api.Assertions.*;

class LuckyTicketsTest {
    TicketsPack ticketsPack=new TicketsPack();
    LuckyTickets luckyTickets=new LuckyTickets();

                //With ValueSource(ints = {0,101101,999999})
//    @BeforeAll
//    void set()throws VariableEnterException{
//        ticketsPack.setMinNumber(0);
//    }

    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void countTickets(Integer integer) throws VariableEnterException{
        ticketsPack.setMinNumber(integer);
        ticketsPack.setMaxNumber(integer);
        assertEquals(luckyTickets.getLuckyTicketsCount1(), luckyTickets.getLuckyTicketsCount2());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void trueCheckTicket_1_SymmetricSource(Integer integer) throws VariableEnterException {
        assertTrue(luckyTickets.checkTicket1(integer));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,101101,885588,999999})
    void trueCheckTicket_2_SymmetricSource(Integer integer) {
        assertTrue(luckyTickets.checkTicket1(integer));
    }

    //
}