package com.muyi.leetcode.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: muyi
 * @date: 2020-12-14 23:38
 *
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class leetcode_49_group_anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList= new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            String sortString = toSortString(strs[i]);
            if(hashMap.containsKey(sortString)){
                Integer index = hashMap.get(sortString);
                resultList.get(index-1).add(strs[i]);
            }else {
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                resultList.add(stringList);
                hashMap.put(sortString,resultList.size());
            }
        }

        return resultList;
    }

    public static String toSortString(String string){
        String result = "";
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        for(int i =0;i<chars.length;i++){
            result+=chars[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
