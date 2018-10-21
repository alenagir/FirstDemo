package test;

import models.Envelope;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.BeforeTest;
import service.EnvelopeCompare;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeCompareTest {
    Envelope envelope1=new Envelope();
    Envelope envelope2=new Envelope();
    EnvelopeCompare envelopeCompare=new EnvelopeCompare();


    @Tag("baseMethod")
    @DisplayName("compare returns 1 with default TOLERANCE=1")
    @ParameterizedTest
    @MethodSource("test.EnvelopeCompareTestProvider#forEnvelopeCompare_Return_1")
    void envelopeCompare_Return_1(Double d1, Double d2,Double d3,Double d4) throws VariableEnterException{
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        int actual = envelopeCompare.compare(envelope1, envelope2);
        int expected=1;
        assertEquals(expected,actual);
    }

    @Tag("baseMethod")
    @DisplayName("compare returns -1 with default TOLERANCE=1")
    @ParameterizedTest
    @MethodSource("test.EnvelopeCompareTestProvider#forEnvelopeCompare_Return_minus_1")
    void envelopeCompare_Return_minus_1(Double d1, Double d2,Double d3,Double d4) throws VariableEnterException{
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        int actual = envelopeCompare.compare(envelope1, envelope2);
        int expected=-1;
        assertEquals(expected,actual);
    }

    @Tag("baseMethod")
    @DisplayName("compare returns 0 with default TOLERANCE=1")
    @ParameterizedTest
    @MethodSource("test.EnvelopeCompareTestProvider#forEnvelopeCompare_Return_0")
    void envelopeCompare_Return_0(Double d1, Double d2,Double d3,Double d4) throws VariableEnterException{
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        int actual = envelopeCompare.compare(envelope1, envelope2);
        int expected=0;
        assertEquals(expected,actual);
    }

    @Tag("baseMethod")
    @DisplayName("compare returns 0 or -1 with TOLERANCE=0")
    @ParameterizedTest
    @MethodSource("test.EnvelopeCompareTestProvider#forEnvelopeCompare_Return_0")
    void envelopeCompare_TOL_0(Double d1, Double d2,Double d3,Double d4) throws VariableEnterException{
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        EnvelopeCompare.setTOLERANCE(0);
        int actual = envelopeCompare.compare(envelope1, envelope2);
        int expected=0;
        assertEquals(expected, actual);
    }



    @Tag("finalMethod")
    @DisplayName("comparingResult returns string with result")
    @ParameterizedTest
    @MethodSource("test.EnvelopeCompareTestProvider#forEnvelopeComparingResult")
    void envelopeCompare(String comparingResult, Double [] sides) throws VariableEnterException{
        String actual = envelopeCompare.comparingResult(envelope1, envelope2, sides);
        String expected=comparingResult;
        assertEquals(expected, actual);
    }

    @DisplayName("Envelope side should not be <= 0 throws VariableEnterException")
    @Tag("exception")
    @ParameterizedTest
    @ValueSource(ints={0, -1})
    void setEnvelopeSides_throwException(double side) {
        assertThrows(VariableEnterException.class,
                ()->{
                    envelope1.setEnvelopeSides(side,1);
                });
    }



}