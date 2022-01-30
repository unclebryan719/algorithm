package arr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
class SortedSquaresTest {

    @DisplayName("计算数组中的平方并排序")
    @ParameterizedTest(name = "{index} => input={0}, output ={1}")
    @MethodSource("sortedProvider")
    void sortedSquares(int[] input, int[] output) {
        assertArrayEquals(output , new SortedSquares().sortedSquares(input));
    }

    private static Stream<Arguments> sortedProvider(){
        return Stream.of(
                Arguments.of(new int[]{-4,-1,0,3,10}, new int[]{0,1,9,16,100}),
                Arguments.of(new int[]{-7,-3,2,3,11}, new int[]{4,9,9,49,121})
        );
    }
}