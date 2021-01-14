package leetcode215;

import java.util.Random;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode215
 * @ClassName: QuickSelect
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/13 下午5:05
 * @Version: 1.0
 * <p>
 * 此题最简单方法是快排。这里的方法优化在于分析入快排的原理。
 */
public class QuickSelect {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int r = nums.length - 1;
        int l = 0;
        int index = nums.length - k;
        return quickSelect(nums, l, r, index);
    }

    private int quickSelect(int[] a, int l, int r, int index) {
        int randomIndex = random.nextInt(r - l + 1) + l;
        int currIndex = partition(a, l, r, randomIndex);
        if (currIndex == index) {
            return a[currIndex];
        } else {
            return currIndex > index ? quickSelect(a, l, currIndex - 1, index) : quickSelect(a, currIndex + 1, r, index);
        }
    }

    private int partition(int[] a, int l, int r, int index) {
        swap(a, r, index);
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] < a[r]) {
                swap(a, j, i++);
            }
        }
        swap(a, r, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
