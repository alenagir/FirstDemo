package test;

import models.Sequence;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {
    Sequence sequence=new Sequence();
    static ArrayList<Integer> expected_4_8=new ArrayList<>();
    ArrayList<Integer> actual=new ArrayList<>();

    @BeforeAll
    static void initAll() {
        expected_4_8= SequenceTestProviderExpected.ARRAY_FROM_4_TO_8_LENGTH_5();
    }

    @Tag("finalMethod")
    @ParameterizedTest
    @ValueSource(ints = {10,11,12,13,14,15,16})
    void getSequenceWithLength_5_minSquareFrom10to16(Integer integer)throws VariableEnterException {
        sequence.setSequencelength(5);
        sequence.setMinSquare(integer);
        actual=sequence.getSequence();

        assertIterableEquals(expected_4_8, actual);

    }

    @Tag("finalMethod")
    @ParameterizedTest
    @MethodSource("range")
    void getSequenceWithLength_5_minSquareFrom10to16(int argument)throws VariableEnterException {
        sequence.setSequencelength(5);
        sequence.setMinSquare(argument);
        actual=sequence.getSequence();

        assertIterableEquals(expected_4_8, actual);
    }

    static IntStream range() {
        return IntStream.range(10, 16);
    }

    @DisplayName("SequenceLength should not be < 1 throws VariableEnterException")
    @Tag("exception")
    @Test
         void setSequenceLength_throwException() {
        assertThrows(VariableEnterException.class,
                ()->{
                    sequence.setSequencelength(0);
                });
    }

    @DisplayName("Sequence MinSquare should not be < 0 throws VariableEnterException")
    @Tag("exception")
    @Test
    void setSequenceMinSquare_throwException() {
        assertThrows(VariableEnterException.class,
                ()->{
                    sequence.setMinSquare(-1);
                });
    }
}