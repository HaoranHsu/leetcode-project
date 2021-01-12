package leetcode215;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: leetcode215
 * @ClassName: HeapManMade
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/13 上午12:03
 * @Version: 1.0
 * 自己写的heap而不用PriorityQueue
 */
public class HeapManMade {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            heaptify(nums, 0, heapSize);
        }
        return nums[0];
    }


    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heaptify(nums, i, heapSize);
        }
    }

    private void heaptify(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int large = i;
        if (l < heapSize && nums[l] > nums[i]) {
            large = l;
        }
        if (r < heapSize && nums[r] > nums[large]) {
            large = r;
        }
        if (large != i) {
            swap(nums, i, large);
            heaptify(nums, large, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
