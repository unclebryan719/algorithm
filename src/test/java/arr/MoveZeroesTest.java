package arr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    @DisplayName("将数组中的0移动到末尾")
    @ParameterizedTest(name = "{index} => input={0},output={1}")
    @MethodSource("zeroProvider")
    void moveZeroes(int[] input, int[] output) {
        assertArrayEquals(output, new MoveZeroes().moveZeroes(input));
    }

    private static Stream<Arguments> zeroProvider(){
        return Stream.of(
                Arguments.of(new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}),
                Arguments.of(new int[]{0,1,0,3,12,15,0,0,2,0,1,0}, new int[]{1,3,12,15,2,1,0,0,0,0,0,0})
        );
    }
}