package io_training;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: io_training
 * @ClassName: t4
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/11 上午11:32
 * @Version: 1.0
 */
public class t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().trim().split(",");
            Arrays.sort(strings);
            for (int i = 0; i < strings.length - 1; i++) {
                System.out.print(strings[i] + ",");
            }
            System.out.println(strings[strings.length - 1]);
        }
    }
}