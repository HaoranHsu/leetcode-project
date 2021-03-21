import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: PACKAGE_NAME
 * @ClassName: sortMethod
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/7 上午1:16
 * @Version: 1.0
 */
public class SortMethod {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 5, 7, 5, 9, 7, 3};
        sortPartition(ints, 0, ints.length - 1);
        for (int num : ints
        ) {
            System.out.print(num);
        }
    }

    private static void sortPartition(int[] ints, int l, int r) {
        //注意有等于 不然sof
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sortPartition(ints, l, mid);
        sortPartition(ints, mid + 1, r);
        merge(ints, l, mid, r);
    }

    private static void merge(int[] ints, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= mid && j <= r) {
            if (ints[i] < ints[j]) {
                temp[k++] = ints[i++];
            } else {
                temp[k++] = ints[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = ints[i++];
        }
        while (j <= r) {
            temp[k++] = ints[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            ints[m + l] = temp[m];
        }
    }
}
