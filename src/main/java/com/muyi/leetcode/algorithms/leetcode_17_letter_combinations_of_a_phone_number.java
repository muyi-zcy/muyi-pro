package com.muyi.leetcode.algorithms;


import com.muyi.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: muyi
 * @Date: 2020/12/16 14:31
 *
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_17_letter_combinations_of_a_phone_number {
    static HashMap<Character,char[]> map;
    public static void initMap(){
        map=new HashMap<Character,char[]>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
    }
    static List<String> resultList;

    public static List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)){
            return new ArrayList<>();
        }
        initMap();
        char[] chars = digits.toCharArray();

        resultList = new ArrayList<>();

        node root = new node();

        searchNode(root,chars,0,"");

        return resultList;
    }

    public static node searchNode(node node,char[] chars,int i,String value){
        if(i == chars.length){
            resultList.add(value);
            return null;
        }
        char[] cc = map.get(chars[i]);
        List<node> childNode = new ArrayList<>();
        for(int j = 0 ;j < cc.length;j++) {
            node n = new node(String.valueOf(cc[j]));
            searchNode(n,chars,i+1,value+String.valueOf(cc[j]));
            childNode.add(n);
        }
        node.nodeList = childNode;
        return node;
    }

    public static void main(String[] args) {
        LogUtil.LogConsole(letterCombinations(""));
    }

}

class node{
    String val;
    List<node> nodeList;

    public node() {}


    public node(String val) {
        this.val = val;
    }

    public node(char[] chars) {
        List<node> nodeList = new ArrayList<>();
        for(int i = 0;i<chars.length;i++){
            node n = new node(String.valueOf(chars[i]));
        }
        this.nodeList = nodeList;
    }
}