package com.merjiezo.simple;

import java.util.Stack;

/***
 * FROM: https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * EXAMPLE:
 * 输入: "()"
 * 输出: true
 *
 * 输入: "()[]{}"
 * 输出: true
 */
public class BracketValidator {

    public static void main (String[] args) {
        BracketValidator bracketValidator = new BracketValidator();
        System.out.println(bracketValidator.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        Stack<String> stack = new Stack<>();
        String[] strs = s.split("");
        int len = strs.length;

        for (int i = 0; i < len; i++) {
            String symbol = strs[i];
            if (stack.empty()) {
                stack.push(symbol);
                continue;
            }
            String val = stack.peek();
            if ("}])".indexOf(symbol) != -1 && isTwine(val, symbol)) {
                stack.pop();
            } else {
                stack.push(symbol);
            }
        }

        return stack.empty();
    }

    private boolean isTwine (String one, String another) {
        return ("{".equals(one) && "}".equals(another))
                || ("[".equals(one) && "]".equals(another))
                || ("(".equals(one) && ")".equals(another));
    }

}
