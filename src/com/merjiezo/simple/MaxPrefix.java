package com.merjiezo.simple;

/**
 * FROM: https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 说明: 所有输入只包含小写字母 a-z 。
 *
 * EXAMPLE:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class MaxPrefix {

    public static void main (String[] args) {
        MaxPrefix maxPrefix = new MaxPrefix();
        String[] test = { "abb","abc" };
        System.out.println(maxPrefix.longestCommonPrefix(test));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }

        int loopTime = findMin(strs);
        String pub = "";
        boolean end = false;
        for (int i = 0; i < loopTime; i++) {
            pub = strs[0].substring(0, i + 1);
            for (int j = 1; j < len; j++) {
                if (strs[j].indexOf(pub) != 0) {
                    end = true;
                    break;
                }
            }
            if (end) {
                pub = pub.substring(0, i);
                break;
            }
        }
        return pub;
    }

    private int findMin(String[] strs) {
        String innerStr = strs[0];
        int minNum = innerStr.length();
        int loop = strs.length;
        for (int i = 1; i < loop; i++) {
            String str = strs[i];
            minNum = Math.min(minNum, str.length());
        }
        return minNum;
    }
}
