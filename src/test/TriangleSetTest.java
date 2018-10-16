package test;

import models.Triangle;
import myExceptions.TriangleException;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.TriangleSet;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSetTest {
    TriangleSet triangleSet=new TriangleSet(TriangleSet.compareBySquare);
    Triangle triangle;

    @ParameterizedTest
    @ValueSource(strings = {"tr1,6,7,8","tr2,3,4,5","tr3,9,10,11"})
    void addTriangleNotNull(String string) throws TriangleException  {
        triangleSet.addTriangle(string);
        assertNotNull(triangleSet);
        assertFalse(triangleSet.triangleTreeSet.isEmpty());
       // assertEquals(3, triangleSet.triangleTreeSet.size());
    }



    @ParameterizedTest
    @ValueSource(strings = {"tr1,6,7,8","tr2,3,4,5","tr3,9,10,11", ",10,10,15", ",9,10,11"})
    void createTriangleNotNull(String string) throws TriangleException {
        triangle=triangleSet.createTriangle(string);
        assertNotNull(triangle.getSquare());
        assertNotNull(triangle.getName());
        assertNotEquals(0, triangle.getSquare());
    }


    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(TriangleException.class, () -> {
            throw new TriangleException("Should be set triangle name and three sides");
        });
        assertEquals("Should be set triangle name and three sides", exception.getMessage());
    }
}

