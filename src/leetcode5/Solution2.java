package leetcode5;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode5
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/18 下午11:15
 * @Version: 1.0
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //不是0 否则很简单的例子a，c 都通不过
        int maxLen = 1;
        int start = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //从j开始，先填充列，dp才能获取前一步的信息!
        //j = 1         i < j not len
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // if dp[j][j] !
                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
