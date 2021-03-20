package leetcode3;

import java.util.HashSet;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode3
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/17 下午10:28
 * @Version: 1.0
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        HashSet<Character> charSet = new HashSet<>();
        int len = s.length();
        int rIndex = -1;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                charSet.remove(s.charAt(i - 1));
            }
            while (rIndex + 1 < len && !charSet.contains(s.charAt(rIndex + 1))) {
                charSet.add(s.charAt(++rIndex));
            }
            ans = Math.max(ans, rIndex - i + 1);
        }
        return ans;
    }
}
