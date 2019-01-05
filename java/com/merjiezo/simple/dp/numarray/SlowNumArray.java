package com.merjiezo.simple.dp.numarray;

public class SlowNumArray {

    private int[] cacheNums;
    private int length = 0;

    public SlowNumArray(int[] nums) {
        if (nums == null) {
            cacheNums = new int[0];
        } else {
            cacheNums = nums;
        }
        length = cacheNums.length;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        int realMin = Math.max(0, i);
        int realMax = Math.min(j, length);

        for (int k = realMin; k <= realMax; k++) {
            res += cacheNums[k];
        }
        return res;
    }
}
