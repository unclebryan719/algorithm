package arr;

/**
 * Leetcode844
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 *
 * 如果相等，返回 true ；否则，返回 false 。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 “”。
 * 示例 3：
 *
 * 输入：s = "a##c", t = "#a#c"
 * 输出：true
 * 解释：s 和 t 都会变成 “c”。
 * 示例 4：
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 “c”，但 t 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackspaceCompare {

    /**
     * 解题思路：
     * 因为这个题目要比较两个字符串的相等情况，即在循环遍历的过程中只能证伪不能证明
     * 也就是需要在循环的过程中将FALSE的情况判断出来，当循环结束时即为TRUE
     *
     * 从后向前遍历字符串，找到有效字符后进行比较；
     * 如果从前向后遍历进行比较的话，找到的字符可能是无效的，因为有退格符，前面的字符有可能被删除
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipNumS = 0;
        int skipNumT = 0;
        // 退出外层循环的条件为证伪，即returnFALSE，或者两个字符串均遍历结束
        // 假设在上一次比较字符串时，其中一个字符串为"ab"另一个字符串为"b"，而上次一比较当前有效字符均为"b"，即在上一次循环中没有证伪；
        // 而在这一次循环中，其中一个字符串的长度为0，即索引下标为-1；
        // 在此种情况下应该继续循环，如果此处用的是并且的关系则外层循环失效，返回结果为TRUE，而实际上a与ab是不相等的，所在此时应该继续遍历，所以条件为或的关系
        while(i >= 0 || j >= 0){
            // 找到第一个非退格字符用于比较
            while(i >= 0){
                // 当为#时，对退格字符进行累计
                if(s.charAt(i) == '#'){
                    skipNumS ++;
                    i --;
                }
                // 当为非退格字符是，同时退格字符计数器中的值大于零，则对退格字符计数进行减操作
                else if (skipNumS > 0 ){
                    skipNumS --;
                    i --;
                }
                // 当为非退格字符并且退格字符计数器的值等于0，即表示已经找到第一个有效非退格字符
                else{
                    break; // 跳出当前循环
                }
            }

            // 找到第一个非退格字符用于比较
            while(j >= 0){
                // 当为#时，对退格字符进行累计
                if(t.charAt(j) == '#'){
                    skipNumT ++;
                    j --;
                }
                // 当为非退格字符是，同时退格字符计数器中的值大于零，则对退格字符计数进行减操作
                else if (skipNumT > 0 ){
                    skipNumT --;
                    j --;
                }
                // 当为非退格字符并且退格字符计数器的值等于0，即表示已经找到第一个有效非退格字符
                else{
                    break; // 跳出当前循环
                }
            }

            if(i >= 0 && j >=0){ // 表示两个字符串均没有遍历结束
                if(s.charAt(i) != t.charAt(j)){ // 此时比较两个字符串的当前字符是否不相等来证伪
                    return false;
                }
            }else{ //表示两个字符串其中有一个遍历结束或者两个均遍历结束
                if(i >= 0 || j >= 0){ // 表示两个字符串只有一个遍历结束，说明其中一个字符串当前的有效字符为空字符，另一个待比较的字符串的当前有效字符为非空字符，则返回结果一定为FALSE
                    return false;
                }
            }

            // 比较完当前有效字符后并没有证伪，则继续向前移动指针进入新一轮的循环并找到下一个待比较的有效字符
            i --;
            j --;
        }

        //退出循环的条件为找到第一个需要比较的字符
        // 如果两个字符串均遍历结束而没有证明两个字符串不相等则直接返回TRUE
        return true;
    }
}