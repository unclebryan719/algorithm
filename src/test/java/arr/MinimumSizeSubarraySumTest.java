package arr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSizeSubarraySumTest {

    @DisplayName("长度最小的子数组")
    @ParameterizedTest(name = "{index} => nums={0}, target={1}, expected={2}")
    @MethodSource("subarrayProvider")
    void getSubarraySum(int[] nums, int target, int expected) {
        assertEquals(expected, new MinimumSizeSubarraySum().getSubarraySum(nums, target));
    }

    private static Stream<Arguments> subarrayProvider(){
        return Stream.of(
                Arguments.of(new int[]{2,3,1,2,4,3}, 7, 2),
                Arguments.of(new int[]{1,4,4}, 4, 1),
                Arguments.of(new int[]{1,1,1,1,1,1,1,1}, 11, 0)
        );
    }
}