package lc39组合求和;

import java.util.*;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc39组合求和
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/9 下午5:27
 * @Version: 1.0
 * 其实不太对
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        findElement(candidates, target, ans, temp);
//        Set<List<Integer>> ansSet = new HashSet<>();
//        for (int i = 0; i < ans.size();i++) {
//            if(!ansSet.contains(ans.get(i))){
//                ansSet.add(ans.get(i));
//            }else {
//                ans.remove(ans.get(i));
//            }
//        }
        return ans;
    }

    private void findElement(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> tempRes = new ArrayList<>(temp);
//            Collections.sort(tempRes);
            ans.add(tempRes);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (temp.size() >= 1 && candidates[i] < temp.get(temp.size() - 1)) {
                continue;
            }
            temp.add(candidates[i]);
            findElement(candidates, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
