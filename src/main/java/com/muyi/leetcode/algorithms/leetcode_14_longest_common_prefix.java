package com.muyi.leetcode.algorithms;

/**
 * @Classname leetcode_14_longest_common_prefix
 * @Description 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/15 下午10:53
 * @Created by muyi
 */
public class leetcode_14_longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length == 0){
            return result;
        }
        char[][] chars = new char[strs.length][];

        for(int i=0;i<strs.length;i++){
            chars[i] = strs[i].toCharArray();
        }

        int index = 0;
        while(true) {
            char c = 'A';
            for (int i = 0; i < chars.length; i++) {
                if(index == chars[i].length){
                    return result;
                }
                if(c == 'A'){
                    c = chars[i][index];
                }else {
                    if(c != chars[i][index]){
                        return result;
                    }
                }
            }
            result += c;
            index ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flow23232232323232323232323232323232323232323er","","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"","dracecar",""}));
        System.out.println(longestCommonPrefix(new String[]{}));
    }
}
