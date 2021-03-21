package lc438;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc438
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/21 上午12:36
 * @Version: 1.0
 * <p>
 * <p>
 * 其实可以用两个int[26]
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd"
                , "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (p.length() == 0 || s.length() == 0 || p.length() > s.length()) {
            return ans;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> preMap = new HashMap<>();

        for (int i = 0; i < pLen; i++) {
            preMap.put(p.charAt(i), preMap.getOrDefault(p.charAt(i), 0) + 1);
        }
//
//        for (int i = 0; i < pLen; i++) {
//            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
//        }

        int l = 0;
        int r = l + pLen - 1;
        for (int i = 0; i <= r; i++) {
            if (preMap.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        while (r < s.length()) {
            /**
             * 如果是两个int[26] 可以用Arrays.equals(sCnt,bCnt) 直接比较
             */
            boolean currFlag = true;
            for (Map.Entry<Character, Integer> e : preMap.entrySet()
            ) {

                if (!map.containsKey(e.getKey())) {
                    currFlag = false;
                    break;
                }
                if (map.containsKey(e.getKey()) && !e.getValue().equals(map.get(e.getKey()))) {
                    currFlag = false;
                    break;
                }
            }
            if (currFlag == true) {
                ans.add(l);
            }
            if (r == s.length() - 1) {
                break;
            }

            if (preMap.containsKey(s.charAt(l))) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
            }
            l++;
            r++;

            if (preMap.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            }

        }
        return ans;

    }
}
