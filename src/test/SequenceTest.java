package test;

import models.Sequence;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    Sequence sequence=new Sequence();
    ArrayList<Integer> arr10=new ArrayList<>();

    @ParameterizedTest
    @ValueSource(ints = {10,11,12,13,14,15,16})
    void getSequenceWithLength_3_minSquareFrom10to16(Integer integer)throws VariableEnterException {
        arr10.add(4);
        arr10.add(5);
        arr10.add(6);
        sequence.setSequencelength(3);
        sequence.setMinSquare(integer);
        assertIterableEquals(arr10, sequence.getSequence());
    }
}