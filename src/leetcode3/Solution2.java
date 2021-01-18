package leetcode3;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode3
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/18 下午6:01
 * @Version: 1.0
 * <p>
 * from another answer
 * 重点在于固定right，而left采用hashmap记下来的位置可以更准确调整
 * <p>
 * left 和 right，如果两层循环 n方复杂度，但是如果采用滑动窗口 n复杂度
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                //因为map能准确记录index，不用去除窗口之前的map记录
                //这样取max的话，就不用从map之中remove之前的了！
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            //这里不用用else！因为map需要记录最新的index。
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
