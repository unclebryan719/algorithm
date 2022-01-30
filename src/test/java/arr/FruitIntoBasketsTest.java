package arr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBasketsTest {

    @DisplayName("水果成篮")
    @ParameterizedTest(name = "{index} => nums = {0}, expected = {1}")
    @MethodSource("fruitProvider")
    void totalFruit(int[] nums, int expected) {
        assertEquals(expected, new FruitIntoBaskets().totalFruit(nums));
    }

    private static Stream<Arguments> fruitProvider(){
        return Stream.of(
                Arguments.of(new int[]{1,2,1}, 3),
                Arguments.of(new int[]{0,1,2,2}, 3),
                Arguments.of(new int[]{1,2,3,2,2}, 4),
                Arguments.of(new int[]{3,3,3,1,2,1,1,2,3,3,4}, 5)
        );
    }
}