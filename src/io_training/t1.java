package io_training;

import java.util.Scanner;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: io_training
 * @ClassName: t1
 * @Author: Tristan Shu
 * @CreateDate: 2021/3/10 下午11:19
 * @Version: 1.0
 */
public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
        scanner.close();
    }
}
//
//    Scanner scan = new Scanner(System.in).useDelimiter("\\D");// 匹配非数字
//		System.out.print("请输入当前日期（年-月-日）:");
//                int year = scan.nextInt();
//                int month = scan.nextInt();
//                int date = scan.nextInt();
//                scan.close(); // 执行关闭
//
//    String input = "1 fish 2 fish red fish blue fish";
//    Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//     System.out.println(s.nextInt());
//             System.out.println(s.nextInt());
//             System.out.println(s.next());
//             System.out.println(s.next());
//             s.close();
//             prints the following output:
//
//             1
//             2
//             red
//             blue