package test;

import models.Triangle;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.BeforeTest;
import service.TriangleSet;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSetTest {
    static TriangleSet triangleSet=new TriangleSet(TriangleSet.comparedBySquare);
    static Set<Triangle> expectedSet = new TreeSet<>(TriangleSet.comparedBySquare);
    static Set<Triangle> actualSet=new TreeSet<>(TriangleSet.comparedBySquare);

    @Tag("baseMethod")
    @DisplayName("createTriangle from entered String")
    @ParameterizedTest
    @MethodSource("test.TriangleSetTestProvider#forCreateTriangle")
    void createTriangle_returnTriangle(Triangle expected, String userEnter) throws VariableEnterException{
        Triangle actual = triangleSet.createTriangle(userEnter);
        assertEquals(expected,actual);
    }


    @BeforeAll
    static void setTreeSet()throws VariableEnterException{
        expectedSet.add(TriangleSetTestProvider.TR1);
        expectedSet.add(TriangleSetTestProvider.TR2);
        expectedSet.add(TriangleSetTestProvider.TR3);
        expectedSet.add(TriangleSetTestProvider.UNNAMED);

        actualSet = triangleSet.addTriangle(TriangleSetTestProvider.tr1);
        actualSet = triangleSet.addTriangle(TriangleSetTestProvider.tr2);
        actualSet = triangleSet.addTriangle(TriangleSetTestProvider.tr3);
        actualSet = triangleSet.addTriangle(TriangleSetTestProvider.unnamed);
    }

    @DisplayName("createTriangle from entered String and add to TreeSet as DESC")
    @Tag("finalMethod")
    @Test
       void addTriangle_returnTreeSet() throws VariableEnterException{
           assertIterableEquals(expectedSet,actualSet);
        }

    @DisplayName("gets from createTriangle TreeSet first Triangle with largest square")
    @Tag("finalMethod")
    @Test
        void addTriangle_returnLargestSquare() throws VariableEnterException {
            Triangle expectedTriangle=TriangleSetTestProvider.TR3;
            Object actualTriangle=((TreeSet) actualSet).first();

            assertEquals(expectedTriangle,actualTriangle);
        }

    @DisplayName("triangle sides should not be <=0 or two sides sum < third side throws VariableEnterException")
    @Tag("exception")
    @ParameterizedTest
    @MethodSource("test.TriangleSetTestProvider#exceptionTriangle")
     void createTriangle_throwException(String userEnter) {
       assertThrows(VariableEnterException.class,
                ()->{
                    triangleSet.createTriangle(userEnter);
                });
    }

}

