package test;

import models.Envelope;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import service.EnvelopeCompare;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeCompareTest {
    Envelope envelope1=new Envelope();
    Envelope envelope2=new Envelope();
    Double sides[]=new Double[4];
    EnvelopeCompare envelopeCompare=new EnvelopeCompare();


    @ParameterizedTest
    @CsvSource({"1,3,5,7", "1000,250,2000,252"})
    void compareSecondEnvelopeLarger(Double d1, Double d2,Double d3,Double d4) {
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        int compareRes=envelopeCompare.compare(envelope1,envelope2);
        assertEquals(-1, compareRes);
    }


    @ParameterizedTest
    @CsvSource({"1,2,1,2", "200.0001,400.0001,200.0001,400.0001"})
    void compareEqualEnvelopesWithTOL_0(Double d1, Double d2,Double d3,Double d4) {
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        EnvelopeCompare.setTOLERANCE(0);
        int compareRes=envelopeCompare.compare(envelope1,envelope2);
        assertEquals(0, compareRes);
    }

    @ParameterizedTest
    @CsvSource({"1,2,2,3", "200,400,99,399"})
    void compareEqualEnvelopesWithTOL_1(Double d1, Double d2,Double d3,Double d4) {
        envelope1.setEnvelopeSides(d1, d2);
        envelope2.setEnvelopeSides(d3, d4);
        EnvelopeCompare.setTOLERANCE(1);
        int compareRes=envelopeCompare.compare(envelope1,envelope2);
        assertEquals(0, compareRes);
    }


    @Test
    void comparingResult() {
    }
}