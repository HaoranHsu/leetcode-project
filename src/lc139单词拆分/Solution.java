package lc139单词拆分;

import java.util.*;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc139单词拆分
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/11 下午3:14
 * @Version: 1.0
 */
class Solution {
    boolean canForm = false;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        judge(s, wordDict, builder);
        return canForm;
    }

    private void judge(String s, List<String> wordDict, StringBuilder builder) {
        if (s.equals(builder.toString())) {
            canForm = true;
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (!equalStart(builder, s)) {
                continue;
            }
            builder.append(wordDict.get(i));
            int len = wordDict.get(i).length();
            judge(s, wordDict, builder);
            builder.delete(builder.length() - len, builder.length());
        }
        System.out.println(builder.toString());
    }

    private boolean equalStart(StringBuilder builder, String s) {
        if (s.length() < builder.length()) {
            return false;
        }
        String tempStr = builder.toString();
        for (int i = 0; i < Math.min(tempStr.length(), s.length()); i++) {
            if (s.charAt(i) != tempStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}