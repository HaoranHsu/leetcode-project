package leetcode300;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode300
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/14 下午10:18
 * @Version: 1.0
 * 降低复杂度切入点： 解法一中，遍历计算 dpdp 列表需 O(N)O(N)，计算每个 dp[k]dp[k] 需 O(N)O(N)。
 * <p>
 * 动态规划中，通过线性遍历来计算 dpdp 的复杂度无法降低；
 * 每轮计算中，需要通过线性遍历 [0,k)[0,k) 区间元素来得到 dp[k]dp[k] 。我们考虑：是否可以通过重新设计状态定义，使整个 dpdp 为一个排序列表；这样在计算每个 dp[k]dp[k] 时，就可以通过二分法遍历 [0,k)[0,k) 区间元素，将此部分复杂度由 O(N)O(N) 降至 O(logN)O(logN)。
 * <p>
 * <p>
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] tail = new int[nums.length];
        int end = 0;
        tail[end] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int l = 0;
                int r = end;
                while (l < r) {
                    int mid = l + (r - l) >> 1;
                    if (nums[i] > tail[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return ++end;
    }
}
