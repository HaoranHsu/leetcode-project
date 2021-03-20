package lc79单词搜索;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc79单词搜索
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/12 下午4:00
 * @Version: 1.0
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean ans = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[r][c];
                    ans |= bfs(board, i, j, visited, word, 0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    private boolean bfs(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if (visited[i][j] || (word.charAt(index) != board[i][j])) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int r = board.length;
        int c = board[0].length;

        boolean up = false, down = false, left = false, right = false;
        if (i + 1 < r) {
            up = bfs(board, i + 1, j, visited, word, index + 1);
            if (up) {
                return true;
            }
        }
        if (j + 1 < c) {
            right = bfs(board, i, j + 1, visited, word, index + 1);
            if (right) {
                return true;
            }
        }
        if (i - 1 >= 0) {
            down = bfs(board, i - 1, j, visited, word, index + 1);
            if (down) {
                return true;
            }
        }
        if (j - 1 >= 0) {
            left = bfs(board, i, j - 1, visited, word, index + 1);
            if (left) {
                return true;
            }
        }
        /**
         * 必须回溯。
         */
        visited[i][j] = false;
        return up || down || left || right;
    }
}