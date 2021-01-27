package leetcode240;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode240
 * @ClassName: Solution4
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/28 上午12:00
 * @Version: 1.0
 * 方法四有点妙啊，这个二维数组就类似一棵排序二叉树，对于每一个数来说，上方的数都小于它，右边的数都大于它，所以把左下角作为根节点开始查找！
 * r w
 */
public class Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null && matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = matrix.length - 1;
        int col = 0;
        while (row > -1 || col < n) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
