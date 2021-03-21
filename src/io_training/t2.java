package io_training;

import java.util.Scanner;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: io_training
 * @ClassName: t2
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/11 上午11:01
 * @Version: 1.0
 */
public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String[] strings = scanner.nextLine().trim().split(" ");
            if (strings[0].equals("0")) {
                break;
            }
            int sum = 0;
            for (String stringE : strings
            ) {
                sum += Integer.parseInt(stringE);
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
