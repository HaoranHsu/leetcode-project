package jo60骰子;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: jo60
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/8 下午2:36
 * @Version: 1.0
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 *  
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * <p>
 * 时间复杂度不合格
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] ans = solution.dicesProbability(2);
        for (double i : ans
        ) {
            System.out.println(i);
        }
    }

    public double[] dicesProbability(int n) {
        int[] nums = new int[6 * n - n + 1];
        patition(n, 0, nums, 0);
        double[] ans = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] / Math.pow(6, n);
        }
        return ans;
    }

    private void patition(int n, int index, int[] nums, int sum) {
        if (index == n) {
            nums[sum - n] += 1;
            return;
        }
        for (int j = 1; j < 7; j++) {
            patition(n, index + 1, nums, sum + j);
        }
    }
}
