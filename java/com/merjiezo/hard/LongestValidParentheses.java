package com.merjiezo.hard;

import java.util.Stack;

/***
 * FROM: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * EXAMPLE:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.ext("(()))())("));
    }

    public int ext(String s) {
        if (null == s
                || s.length() < 2) {
            return 0;
        }
        Stack<String> ss = new  Stack<>();
        String[] sArr = s.split("");
        int len = sArr.length;
        int max = 0;
        boolean isDone = false;

        for (int i = 0; i < len; i++) {
            String str = sArr[i];
            if (isRight(str)) {
                if (ss.empty()) {
                    ss.push(str);
                } else {
                    // Only Right
                    popThenPush(ss);
                }
            } else {
                ss.push(str);
            }
        }

        while(!ss.empty()) {
            String str = ss.pop();
            if ("()".indexOf(str) < 0) {
                max = Math.max(Integer.valueOf(str), max);
            }
        }

        return max;
    }

    private boolean isRight (String s) {
        return s.equals(")");
    }

    private void popThenPush (Stack<String> ss) {
        String peekStr = ss.peek();
        if ("(".equals(peekStr)) {
            ss.pop();
            int val = dropAndPopNumUntilThereIsNoNumInBehind(ss) + 2;
            ss.push("" + val);
        } else if (")".equals(peekStr)) {
            ss.push(")");
        } else {
            // 为值(推出直到没值存在)
            int val = dropAndPopNumUntilThereIsNoNumInBehind(ss);
            if (!ss.empty()) {
                String str = ss.peek();
                if ("(".equals(str)) {
                    ss.pop();
                    val = dropAndPopNumUntilThereIsNoNumInBehind(ss) + val + 2;
                    ss.push("" + val);
                } else if (")".equals(str)) {
                    ss.push("" + val);
                    ss.push(")");
                }
            } else {
                ss.push("" + val);
                ss.push(")");
            }
        }

    }

    private int dropAndPopNumUntilThereIsNoNumInBehind (Stack<String> ss) {
        int res = 0;
        boolean isDone = false;
        while (!isDone) {
            if (!ss.empty()) {
                String str = ss.peek();
                isDone = "(".equals(str) || ")".equals(str);
                System.out.println(isDone);
                if (!isDone) {
                    res += Integer.valueOf(ss.pop());
                }
            } else {
                isDone = true;
            }
        }
        return res;
    }

    public int ext1(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    public int calc(char[] chars, int i, int flag, int end, char cTem) {
        //max用来记录找到的数据
        //validLen用来更新记录
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                //找到一组就记录给max
                max = Math.max(max,validLen);
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        //这一步最大值是为了防止最后的时候还有变化
        return Math.max(max,validLen);
    }
}
