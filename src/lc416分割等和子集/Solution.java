package lc416分割等和子集;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: lc416分割等和子集
 * @ClassName: Solution
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/9 上午9:54
 * @Version: 1.0
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
 * 用子问题定义状态：即f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：
 * <p>
 * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
 * <p>
 * <p>
 * <p>
 * for i=1..N
 * for v=V..0
 * f[v]=max{f[v],f[v-c[i]]+w[i]};
 * <p>
 * <p>
 * 我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。有的题目要求“恰好装满背包”时的最优解，有的题目则并没有要求必须把背包装满。一种区别这两种问法的实现方法是在初始化的时候有所不同。
 * <p>
 * 如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。
 * <p>
 * 如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。
 * <p>
 * 为什么呢？可以这样理解：初始化的f数组事实上就是在没有任何物品可以放入背包时的合法状态。如果要求背包恰好装满，那么此时只有容量为0的背包可能被价值为0的nothing“恰好装满”，其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是-∞了。如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，这个解的价值为0，所以初始时状态的值也就全部为0了。
 * <p>
 * 这个小技巧完全可以推广到其它类型的背包问题，后面也就不再对进行状态转移之前的初始化进行讲解。
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums
        ) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                if (dp[i][target] == true) {
                    return true;
                }
            }
        }
        return dp[len - 1][target] == true;
    }
}
