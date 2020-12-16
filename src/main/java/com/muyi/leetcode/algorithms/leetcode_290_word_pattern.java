package com.muyi.leetcode.algorithms;

import java.util.HashMap;

/**
 * @Author: muyi
 * @Date: 2020/12/16 13:26
 *
 * 290. 单词规律
 *
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_290_word_pattern {
    public static  boolean wordPattern(String pattern, String s) {
        //拆分为数组
        char[] chars = pattern.toCharArray();
        String[] ps  = new String[chars.length];
        for(int i = 0;i<chars.length;i++){
            ps[i] = String.valueOf(chars[i]);
        }
        String[] ss = s.split(" ");

        if(ss.length != ps.length){
            return false;
        }

        //两个数组规律相等的唯一对应的关系是位置相同，
        // 利用字符串pattern 维护一张hash值和序号的字典表：
        // 即第一个出现的字符编号为0;第二个出现的字符编号为2，凡是后面出现字典内已经保存的数字，从字典获取相应编号；
        int num = 0;
        int[] numPs = new int[chars.length];
        HashMap<String,Integer> hP = new HashMap<>();
        for(int i = 0;i<ps.length;i++){
            if(hP.containsKey(ps[i])) {
                int on = hP.get(ps[i]);
                numPs[i] = on;
            }else {
                numPs[i] = num;
                hP.put(ps[i],num);
                num++;
            }
        }

        //可以利用第二张表直接去第一张表的字典表匹配，也可以制作第二张字典表（最后字典两个字典表维护的序号相同）
        num = 0;
        int[] numSs = new int[chars.length];
        HashMap<String,Integer> sP = new HashMap<>();
        for(int i = 0;i<ss.length;i++){
            if(sP.containsKey(ss[i])) {
                int on = sP.get(ss[i]);
                numSs[i] = on;
            }else {
                numSs[i] = num;
                sP.put(ss[i],num);
                num++;
            }
        }

        for(int i =0;i< ss.length;i++){
            if(numPs[i] != numSs[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaaa","dog dog dog dog"));
    }
}
