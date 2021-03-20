//package leetcode131;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Copyright (C), 2019-2021, CPS Lab
// *
// * @ProjectName: leetcode_project
// * @Package: leetcode131
// * @ClassName: Solution
// * @Author: Tristan Shu
// * @CreateDate: 2021/3/7 上午1:12
// * @Version: 1.0
// */
//public class Solution {
//    List<List<String>> ans;
//    public List<List<String>> partition(String s) {
//        ans = new ArrayList<>();
//        if(s.length() == 0){
//            return ans;
//        }
//        char[] chars = s.toCharArray();
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        for (int r = 0; r < s.length(); r++) {
//            for (int l = 0; l <= r; l++) {
//                if(chars[l] == chars[r] && (r - l <=2 || dp[l + 1][r - 1]){
//                    dp[l][r] = true;
//                }
//            }
//        }
//        List<String> list = new ArrayList<>();
//        traceBack(dp,chars,0,chars.length - 1,list);
//        return ans;
//    }
//
//    private void traceBack(boolean[][] dp, char[] chars, int l, int r, List<String> list) {
//        /**
//         * =不能写
//         */
//        if(l > r){
//            /**
//             * 一定要new一个
//             */
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = l; i < r + 1; i++) {
//            if(dp[l][i]){
//                char[] temp = Arrays.copyOfRange(chars,l,i+1);
//                list.add(new String(temp));
//                traceBack(dp, chars,i+1,r,list);
//                list.remove(list.size() - 1);
//            }else {
//                continue;
//            }
//        }
//    }
//
////    private boolean isCorrect(char[] chars,int l , int r){
////        while (l < r){
////            if(chars[l] != chars[r]){
////                return false;
////            }else {
////                l++;
////                r--;
////            }
////        }
////        return true;
////    }
//}
