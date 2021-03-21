//package lc51N皇后;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Copyright (C), 2019-2021, CPS Lab
// *
// * @ProjectName: leetcode_project
// * @Package: lc51N皇后
// * @ClassName: Solution
// * @Author: Tristan Shu
// * @CreateDate: 2021/3/14 上午11:55
// * @Version: 1.0
// */
//public class Solution {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> ans = new ArrayList<>();
//        List<String> level = new ArrayList<>();
//        backTrace(n, level, ans, new StringBuilder());
//    }
//
//    private void backTrace(int n, List<String> level, List<List<String>> ans, StringBuilder builder) {
//        if (level.size() == n) {
//            ans.add(new ArrayList<>(level));
//        }
//        for (int i = 0; i < n; i++) {
//            if (valid()) {
//                builder.append("Q");
//            } else {
//                builder.append(".");
//            }
//        }
//    }
//}
