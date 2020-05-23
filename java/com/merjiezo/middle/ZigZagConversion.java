package com.merjiezo.middle;

import java.util.ArrayList;
import java.util.List;

/***
 * FROM: https://leetcode-cn.com/problems/zigzag-conversion/solution/
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * EXAMPLE:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        zigZagConversion.convert("LEETCODEISHIRING", 3);
    }

    public String convert (String s, int numRows) {
        if (null == s || "".equals(s) || numRows < 0 || numRows == 1) {
            return s;
        }
        List<StringBuffer> res = new ArrayList<>();
        int listLen = Math.min(numRows, s.length());
        for (int i = 0; i < listLen; i++) {
            res.add(new StringBuffer());
        }
        int denominator = numRows - 1;
        int nowArrayIndex = 0;
        int nowIndex = 0;
        for (int j = 0; j < s.length(); j++) {
            StringBuffer innerString = res.get(nowIndex);
            innerString.append(String.valueOf(s.charAt(j)));
            if (nowIndex == denominator || ((nowArrayIndex % denominator) != 0)) {
                nowIndex -= 1;
                nowArrayIndex += 1;
            } else {
                nowIndex += 1;
            }
        }
        StringBuffer rows = new StringBuffer();
        for (int k = 0; k < res.size(); k++) {
            rows.append(res.get(k));
        }
        return rows.toString();
    }

    public String slowlestConvert(String s, int numRows) {
        if (null == s || "".equals(s) || numRows < 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        List<String[]> list = new ArrayList<>();
        int denominator = numRows - 1;
        int nowArrayIndex = 0;
        int nowIndex = 0;
        // 反转内容
        boolean addNewRow = true;
        String[] arr = null;
        for (int i = 0; i < s.length(); i++) {
            if (addNewRow) {
                arr = new String[numRows];
                list.add(arr);
            }
            arr[nowIndex] = String.valueOf(s.charAt(i));
            if (
                nowIndex == denominator
                ||
                ((nowArrayIndex % denominator) != 0)
            ) {
                nowIndex -= 1;
                addNewRow = true;
                nowArrayIndex += 1;
            } else {
                nowIndex += 1;
            }
        }
        // 拼装结果
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < list.size(); k++) {
                String suffix = list.get(k)[j];
                if (suffix != null) {
                    res.append(suffix);
                }
            }
        }
        return res.toString();
    }
}
