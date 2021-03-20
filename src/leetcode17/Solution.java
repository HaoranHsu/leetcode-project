package leetcode17;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode17
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/21 下午8:47
 * @Version: 1.0
 * r & w
 */
public class Solution {
    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        traceBack(0, digits, phoneMap, new StringBuilder());
        return ans;
    }

    private void traceBack(int index, String digits, Map<Character, String> phoneMap, StringBuilder combination) {
        if (index == digits.length()) {
            ans.add(combination.toString());
            return;
        }
        //这里注意是char digit，不是int digit
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            traceBack(index + 1, digits, phoneMap, combination);
            combination.deleteCharAt(index);
        }
    }
}
