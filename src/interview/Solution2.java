//package interview;
//
//public class TestSquare {
//    public static boolean isTrangle(int[] x, int[] y) {
//        boolean flag1 = false;//等腰标志
//        boolean flag2 = false;//直角标志
//        int[] d = new int[3];//存储这三点之间的距离的平方
//        for (int i = 0, k = 0; (i < 3) && (k < 3); i++, k++) {//length=4,任选三个点，例如x0,x1,x2,计算这三个点之间的距离
//            if (k < 2 && i < 2) {
//                d[k] = (x[i] - x[i + 1]) * (x[i] - x[i + 1]) + (y[i] - y[i + 1]) * (y[i] - y[i + 1]);
//            } else {
//                d[k] = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
//            }
//
//        }
//        int c = d[0];//长边
//        int a = 0;//等腰的短边
//        for (int i = 1; i < d.length; i++) {
//            //任意两条边相等，则为等腰三角形
//            if (d[i] == d[i - 1]) {//比较d1,d0 d2,d1
//                flag1 = true;
//                a = d[i];
//
//            }
//            if (d[i] > d[i - 1]) {//挑出最长的那条边
//                c = d[i];
//            }
//
//        }
//        if (d[0] == d[2]) {//还有d0,d2需要进行比较
//            flag1 = true;
//            a = d[0];
//
//        }
//        if (!flag1) {//不是等腰三角形，则肯定不是正方形
//            return false;
//        }
//
//        if (a * 2 == c) {
//            flag2 = true;
//        }
//        return flag1 && flag2;
//    }
//
//
//    public static void main(String[] args) {
////
////        Scanner sc = new Scanner(System.in);
////        int t = sc.nextInt();
////
////        int[] x = new int[4];
////        int[] y = new int[4];
////        boolean[] flags = new boolean[t];
////
////        for (int k = 0; k < t; k++) {
////            int[] d = new int[3];
////            for (int i = 0; i < 4; i++) {
////                x[i] = sc.nextInt();
////            }
////            for (int j = 0; j < 4; j++) {
////                y[j] = sc.nextInt();
////            }
////            boolean f1 = TestSquare.isTrangle(new int[]{x[0], x[1], x[2]}, new int[]{y[0], y[1], y[2]});
////            boolean f2 = TestSquare.isTrangle(new int[]{x[0], x[2], x[3]}, new int[]{y[0], y[2], y[3]});
////
////            flags[k] = f1 && f2;
////
////        }
////
////        for (boolean b : flags) {
////            if (b) {
////                System.out.println("Yes");
////            } else {
////                System.out.println("No");
////            }
////        }
//    }
//}