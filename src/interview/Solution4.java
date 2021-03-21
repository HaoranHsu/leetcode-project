package interview;

import java.util.Arrays;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: interview
 * @ClassName: Solution4
 * @Author: Tristan Shu
 * @CreateDate: 2021/2/23 下午3:09
 * @Version: 1.0
 */
public class Solution4 {
    public String multiply(String a, String b) {
        if (a == null || b == null) {
            return "Error";
        }
        int len1 = a.length();
        int len2 = b.length();
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        //存储临时结果
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        int[] ans = new int[len1];
        int[] temp;
        //错位相加的differ
        int pos = 0;
        for (int i = chars1.length - 1; i >= 0; i--) {
            nums1[i] = Integer.parseInt(String.valueOf(chars1[i]));
        }
        for (int i = chars2.length - 1; i >= 0; i--) {
            nums2[i] = Integer.parseInt(String.valueOf(chars2[i]));
        }
        for (int i = len2 - 1; i >= 0; i--) {
            //数组2中的每一位与第一个数字数组相乘
            temp = new int[len1];
            for (int j = len1 - 1; j >= 0; j--) {
                temp[j] = nums1[j] * nums2[i];
            }
            //错位相加
            for (int k = 0; k < len1; k++) {
                ans[len1 - 1 - k - pos] += temp[len1 - 1 - k];
            }
            pos++;

        }
        for (int i = len1 - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        return Arrays.toString(ans);
    }
}

