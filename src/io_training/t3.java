package io_training;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: io_training
 * @ClassName: t3
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/11 上午11:22
 * @Version: 1.0
 */
public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(scanner.next());
            builder.append(" ");
        }
        String[] strings = builder.toString().trim().split(" ");
        Arrays.sort(strings);
        for (String e : strings
        ) {
            System.out.print(e + " ");
        }
    }
}
