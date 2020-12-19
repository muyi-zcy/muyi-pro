package com.muyi.leetcode.algorithms;

/**
 * @author: muyi
 * @date: 2020-12-18 20:17
 * 389. 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class leetcode_389_find_the_difference {
    public static char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        int sn = 0;
        for(int i =0 ;i<ss.length;i++){
            sn+=(int)ss[i];
        }
        int tn = 0;
        for(int i =0 ;i<ts.length;i++){
            tn+=(int)ts[i];
        }

        return (char)(tn-sn);

    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("","a"));
    }

}
