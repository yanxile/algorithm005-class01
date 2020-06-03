//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] n = new int[]{9, 9, 9, 9};
        int[] r = solution.plusOne(n);
        System.out.println(Arrays.toString(r));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] plusOne(int[] n) {
            for (int i = n.length - 1; i >= 0; i--) {
                n[i]++;
                n[i] %= 10;
                if (n[i] != 0) {
                    return n;
                }
            }
            int[] r = new int[n.length + 1];
            r[0] = 1;
            return r;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}