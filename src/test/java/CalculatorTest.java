import org.example.Calculator;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.anyOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTest {
    public Calculator calc = Calculator.instance.get();
    public Calculator calc2 = new Calculator();

    @ParameterizedTest
    @MethodSource("methodSoursePlus")

    public void parametraizedPlusTest(int a, int b, int executed) {
        var result = calc.plus.apply(a, b);

        Assertions.assertEquals(result, executed);
    }

    public static Stream<Arguments> methodSoursePlus() {
        return Stream.of(Arguments.of(2, 3, 5),
                Arguments.of(4, 5, 9),
                Arguments.of(-2, 3, 1));
    }

    @ParameterizedTest
    @MethodSource("methodSoursePow")
    public void parametraizedPowTest(int a, int executed) {
        var result = calc.pow.apply(a);

        Assertions.assertEquals(result, executed);
    }

    public static Stream<Arguments> methodSoursePow() {
        return Stream.of(Arguments.of(2, 4),
                Arguments.of(3, 9),
                Arguments.of(5, 25));
    }

    @Test
    public void multiplyTest() {
        int a = 3;
        int b = 4;
        int executed = 12;

        var result = calc.multiply.apply(a, b);

        Assertions.assertEquals(result, executed);

    }

    @Test
    public void whenNotNullthenCorrect() {
        String str = calc.name;
        assertThat(str, notNullValue());
    }

    @Test
    public void stringEquels() {
        String string = calc.name;
        assertThat(string, equalTo("ALEX"));
    }


}