package com.merjiezo.simple;

public class AddBinary {

    public static void main (String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.ext("111000", "10111010"));
    }

    public String ext(String a, String b) {
        if (null == a || null == b) {
            return "";
        }
        if (a == "") {
            return b;
        }
        if (b == "") {
            return a;
        }

        String bg;
        String sm;
        if (a.length() >= b.length()) {
            bg = a;
            sm = b;
        } else {
            bg = b;
            sm = a;
        }

        String[] bgArr = bg.split("");
        String[] smArr = sm.split("");
        int carry = 0;
        int loop = bgArr.length;
        int smLen = smArr.length;
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < loop; i++) {
            int index = loop - i - 1;
            int indexSm = smLen -i - 1;
            int nowIndex = Integer.valueOf(bgArr[index]) + carry;
            if (indexSm >= 0) {
                nowIndex += Integer.valueOf(smArr[indexSm]);
            }
            carry = nowIndex / 2;
            res.insert(0, String.valueOf(nowIndex % 2));
        }
        if (carry == 1) {
            res.insert(0, "1");
        }
        return res.toString();
    }
}
