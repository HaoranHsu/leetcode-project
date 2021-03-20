package lc49字母异或词分组;

import java.util.*;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc49字母异或词分组
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/12 下午5:41
 * @Version: 1.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
                map.get(temp).add(strs[i]);
            } else {
                map.get(temp).add(strs[i]);
            }
        }
//        for (Map.Entry<String,List<String>> e:map.entrySet()
//             ) {
//            ans.add(e.getValue());
//        }

        return new ArrayList<List<String>>(map.values());
    }
}