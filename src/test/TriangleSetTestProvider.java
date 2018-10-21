package test;

import models.Triangle;
import org.junit.jupiter.params.provider.Arguments;
import service.TriangleSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TriangleSetTestProvider {
    static final Triangle TR1=new Triangle("tr1", 3.0, 4.0, 5.0, 6.0);
    static final Triangle TR2=new Triangle("tr2", 10.0, 6.0, 8.0,24.0);
    static final Triangle TR3=new Triangle("tr3", 10.0, 12.0, 10.0,48);
    static final Triangle UNNAMED=new Triangle("Triangle", 10.0, 12.0, 10.0,48);

    static final String tr1="tr1,3,4,5";
    static final String tr2="tr2,10,6,8";
    static final String tr3="tr3,10,12,10";
    static final String unnamed=",10,12,10";

    static final String var_enter_exception_minus=",-10,12,10";
    static final String var_enter_exception_0=",0,12,10";
    static final String var_enter_exception_triangle_sides=",1,2,3";//this triangle cannot exist


    static Stream<Arguments> forCreateTriangle() {
        return Stream.of(
                arguments(TR1, tr1 ),//EXPECTED RESULT, "Data provider"
                arguments(TR2, tr2),
                arguments(TR3, tr3),
                arguments(UNNAMED, unnamed)
        );
    }

    static Stream<String> exceptionTriangle() {
        return Stream.of(
                var_enter_exception_minus,
                var_enter_exception_0,
                var_enter_exception_triangle_sides
        );
    }




}
