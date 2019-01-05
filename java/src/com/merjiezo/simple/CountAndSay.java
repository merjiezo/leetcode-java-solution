package com.merjiezo.simple;

import java.util.Stack;

/***
 * FROM: https://leetcode-cn.com/problems/count-and-say/
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * EXAMPLE:
 * 输入: 1
 * 输出: "1"
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

    public static void main (String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.ext(10));
    }

    public String ext(int n) {
        if (n == 0) { return ""; }
        if (n == 1) {
            return "1";
        }

        String nowNum = "1";
        for (int i = 2; i <= n; i++) {
            nowNum = nextOne(nowNum);
        }
        return nowNum;
    }

    private String nextOne(String num) {
        String rtnNumStr = "";
        Stack<String> numStack = new Stack<>();
        String[] strs = num.split("");
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            String nowNum = strs[i];
            if (numStack.empty()
                    || numStack.peek().equals(nowNum)) {
                numStack.push(nowNum);
            } else {
                String numStr = numStack.peek();
                rtnNumStr += numStack.size();
                rtnNumStr += numStr;
                numStack.clear();
                numStack.push(nowNum);
            }
        }
        if (!numStack.empty()) {
            String numStr = numStack.peek();
            rtnNumStr += numStack.size();
            rtnNumStr += numStr;
        }
        return rtnNumStr;
    }
}
