package test;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class EnvelopeCompareTestProvider {
    static final Double FIRST_LARGER[]={5.0, 10.0, 2.5, 5.0};
    static final  Double FIRST_LARGER_SECOND_REVERSED[]={5.0, 10.0, 5.0, 2.5};
    static final  Double SECOND_LARGER[]={2.5,5.0, 5.0,10.0};
    static final  Double SECOND_LARGER_FIRST_REVERSED[]={5.0,2.5, 5.0,10.0};
    static final  Double EQUAL_WITH_TOLERANCE_1[]={4.0,5.0, 5.0,10.0};
    static final  Double EQUAL_WITH_TOLERANCE_0[]={5.0,5.0, 5.0,10.0};

    static Stream<Arguments> forEnvelopeCompare_Return_1() {
        return Stream.of(
                arguments(FIRST_LARGER),
                arguments(FIRST_LARGER_SECOND_REVERSED)
        );
    }

    static Stream<Arguments> forEnvelopeCompare_Return_minus_1() {
        return Stream.of(
                arguments(SECOND_LARGER),
                arguments(SECOND_LARGER_FIRST_REVERSED)
        );
    }

    static Stream<Arguments> forEnvelopeCompare_Return_0() {
        return Stream.of(
                arguments(EQUAL_WITH_TOLERANCE_1),
                arguments(EQUAL_WITH_TOLERANCE_0)
        );
    }

    static Stream<Arguments> forEnvelopeComparingResult() {
        return Stream.of(
                arguments("The first is larger.",FIRST_LARGER),//""Expected test result", DATA_PROVIDER
                arguments("The second is larger.",SECOND_LARGER),
                arguments("Might be equal within the tolerance in at least one of the sides",EQUAL_WITH_TOLERANCE_1)
        );
    }

}

