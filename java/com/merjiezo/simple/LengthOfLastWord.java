package com.merjiezo.simple;

/***
 * FROM: https://leetcode-cn.com/problems/length-of-last-word/submissions/
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * EXAMPLE:
 * 输入: "Hello World"
 * 输出: 5
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.ext("Hello World"));
    }

    public int ext(String s) {
        if (s == null) {
            return 0;
        }
        String[] sArr = s.split(" ");
        int len = sArr.length;
        if (len > 0) {
            return sArr[len - 1].length();
        }
        return 0;
    }

}
