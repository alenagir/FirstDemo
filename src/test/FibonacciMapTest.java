package test;

import com.sun.tracing.dtrace.ProviderAttributes;
import models.FibonacciMap;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FibonacciMapTest {

    FibonacciMap fibonacciMap = new FibonacciMap();
//    @ProviderAttributes("/fibonacci.csv")
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/fibonacci.csv", delimiter='\t')
//    void CsvFileSourceCalcFibonacci0to1000(Integer integer, Long ln) {
//        assertNotNull(integer);
//    }



}