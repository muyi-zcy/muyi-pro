package com.muyi.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: muyi
 * @Date: 2020/12/15 12:26
 *
 * 738. 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 *
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_738_monotone_increasing_digits {
    public static int monotoneIncreasingDigits(int N) {

        char[] chars = String.valueOf(N).toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        Integer M = N;
        while (true) {
            Integer index = getErrorIndex(ints);
            if (index < 0) {
                return M;
            }

            M = 0;
            for (int i = 0; i < ints.length; i++) {
                if(i > index) {
                    ints[i] = 9;
                }
                if(i == index)  {
                    ints[i] = ints[i]-1;
                }
                M = M*10 + ints[i];
            }
        }
    }

    public static int getErrorIndex(int[] ints){
        int index = -1;
        for (int i = 0; i < ints.length - 1; i++) {
            if(ints[i] > ints[i+1]) {
                return i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(9));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(993856657));
        System.out.println(monotoneIncreasingDigits(322));
        System.out.println(monotoneIncreasingDigits(668841));
    }
}
