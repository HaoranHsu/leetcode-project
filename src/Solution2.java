/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: PACKAGE_NAME
 * @ClassName: Solution2
 * @Author: Tristan Shu
 * @CreateDate: 2021/1/20 下午8:12
 * @Version: 1.0
 */
public class Solution2 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            //这样来确定没有有溢出，先乘，再除回来，妙。
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
    //或者
//    public int reverse(int x) {
//        int rev = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            rev = rev * 10 + pop;
//        }
//        return rev;
//    }

}
