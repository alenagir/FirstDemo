package test;

import models.FibonacciMap;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.Tag;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.*;

public class FibonacciMapTestNG {

    FibonacciMap fibonacciMap = new FibonacciMap();
    Collection<Long> actualFib=new ArrayList<>();
    Collection<Long> expectedFib=new ArrayList<>();


    @Tag("finalMethod")
    @Test(dataProvider = "fibSeries")
    public void testCalcFibonacci(long fibSeries[]) throws VariableEnterException {
        int digit=(Long.toString(fibSeries[0])).length();//Finds the number of
        String userEnter=Integer.toString(digit);        //digits in the numbers of the series
        fibonacciMap.setRange(userEnter);

        actualFib=fibonacciMap.calcFibonacci().values();

        for (int i = 0; i < fibSeries.length ; i++) {
            expectedFib.add(fibSeries[i]);  //Accumulates fib numbers from the previous cycle as fibonacciMap does
        }
        assertEquals(expectedFib,actualFib);
    }

    @DataProvider(name = "fibSeries")
    public Object[][] fibSeries() {
        return new Object[][]{
                {0, 1, 1, 2, 3, 5, 8},
                {13, 21, 34, 55, 89},
                {144, 233, 377, 610, 987},
                {1597, 2584, 4181, 6765},
                {10946, 17711, 28657, 46368, 75025},
                {121393, 196418, 317811, 514229, 832040},
                {1346269, 2178309, 3524578, 5702887, 9227465},
                {14930352, 24157817, 39088169, 63245986},
                {102334155, 165580141, 267914296, 433494437, 701408733}

        };
    }

    @Tag("exception")
    @Test(dataProvider = "fibException")
    void setEnvelopeSides_throwException(String userEnter) {
        assertThrows(VariableEnterException.class,
                ()->{
                    fibonacciMap.setRange(userEnter);
                });
    }

    @DataProvider(name = "fibException")
    public Object[][] userEnter_exception() {
        return new Object[][]{
                {"3-2-1"},
                {"-2"},
                {"0"},
                {"a"}
        };
        }

}