package arr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceCompareTest {
    BackspaceCompare backspaceCompare = new BackspaceCompare();
    @BeforeEach
    void setUp() {

    }

    @DisplayName("比较两个带有退格符的字符串是否相等")
    @ParameterizedTest(name = "{index} => s={0}, t ={1}, isEquals={2}")
    @MethodSource("compareProvider")
    void backspaceCompare(String s, String t, boolean isEquals) {
        assertEquals(isEquals, backspaceCompare.backspaceCompare(s, t));
    }

    private static Stream<Arguments> compareProvider(){
        return Stream.of(
                Arguments.of("ab#c", "ad#c", true),
                Arguments.of("ab##", "c#d#", true),
                Arguments.of("a##c", "#a#c", true),
                Arguments.of("a#c", "b", false)
        );
    }

}