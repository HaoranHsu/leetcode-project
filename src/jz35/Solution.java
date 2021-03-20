package jz35;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jz35
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/7 上午11:03
 * @Version: 1.0
 */
public class Solution {
    private static int MOD = 1000000007;

    public int InversePairs(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        return partition(array, 0, array.length - 1) % MOD;
    }

    private int partition(int[] ints, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int lNum = partition(ints, l, mid);
        int rNum = partition(ints, mid + 1, r);
        if (ints[mid] <= ints[mid + 1]) {
            return lNum + rNum;
        }
        return merge(ints, l, mid, r) + lNum + rNum;
    }

    private int merge(int[] ints, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int count = 0;
        for (int k = 0; k < r - l + 1; k++) {
            //mid [+1]！！！
            if (i == mid + 1) {
                //k不用++！！！
                temp[k] = ints[j++];
            } else if (j == r + 1) {
                temp[k] = ints[i++];
            } else if (ints[i] <= ints[j]) {
                temp[k] = ints[i++];
            } else {
                temp[k] = ints[j++];
                count += (mid - i + 1) % MOD;
            }
        }
        for (int m = 0; m < r - l + 1; m++) {
            ints[m + l] = temp[m];
        }
        return count % MOD;
    }
}
