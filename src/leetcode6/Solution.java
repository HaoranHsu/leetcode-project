package leetcode6;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode6
 * @ClassName: interview.Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/19 下午7:54
 * @Version: 1.0
 * <p>
 * 二维数组？no. 标志位和循环can achieve everything!
 * 应该用什么临时存取呢 return string的话 就用StringBuilder。
 * 临时存取的buffer是什么样的呢 列 还是 行？这样就能思考出来了！
 */
public class Solution {
    public String convert(String s, int numRows) {

        int len = s.length();

        if (len == 1 || numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < Math.min(numRows, len); i++) {
            rows.add(new StringBuilder());
        }

        boolean goingDown = false;
        int currRow = 0;

        for (char c : chars) {
            if (currRow >= numRows) {
                break;
            }
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : rows) {
            builder.append(row);
        }
        return builder.toString();
    }
}