package leetcode5;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode5
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/18 下午6:20
 * @Version: 1.0
 * <p>
 * 和前两题一样。无非是确定的是中点。有的确定的是起点，有的是终点，这里是中间点（一个点，或者中间两个点！）。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int startIndex = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            //回文可能是偶数可能是奇数
            int evenLength = expandAroundCenter(chars, i, i + 1);
            int oddLength = expandAroundCenter(chars, i, i);
            if (Math.max(evenLength, oddLength) > maxLength) {
                if (evenLength > oddLength) {
                    maxLength = evenLength;
                    startIndex = -maxLength / 2 + i + 1;
                } else {
                    maxLength = oddLength;
                    startIndex = i - (maxLength - 1) / 2;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    private int expandAroundCenter(char[] chars, int i, int j) {
        int left = i;
        int right = j;
        while (right < chars.length && left >= 0) {
            if (chars[right] != chars[left]) {
                break;
            }
            right++;
            left--;
        }
        return right - left - 1;
    }
}
