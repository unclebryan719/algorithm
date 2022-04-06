package arr;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unclebryan
 * @version 1.0
 * @project algorithm
 * @description 最小覆盖子串
 * @date 2022/2/24 21:32:09
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        Counter counter = new Counter();
        char[] sChars = s.toCharArray();
        int left = 0;
        int pos = 0;
        for(int right = 0; right < sChars.length; right++){
            if(( pos = t.indexOf(sChars[right])) != -1){
                counter.add(pos, 1);
            }
            while (t.length() == counter.size()){
                if( (pos = t.indexOf(sChars[left])) != -1 && counter.get(pos) > 1){
                    counter.add(pos, -1);
                    left ++;
                }
                return s.substring(left,right);
            }
        }
        return "";
    }
    class Counter extends HashMap<Integer, Integer> {
        public int get(int key) {
            return containsKey(key) ? super.get(key) : 0;
        }
        public void add(int key, int value) {
            put(key, get(key) + value);
        }
    }
}
