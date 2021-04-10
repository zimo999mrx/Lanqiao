package _刷题.LanqiaoBei._2015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.dotcpp.com/oj/problem2261.html
 * https://www.bilibili.com/video/BV1GE411F7Pj?p=289
 * 用矩阵来快速幂运算最快
 * 有小错误，先不管了，用到再说
 */

public class B09_垒骰子 {
    static int[] op = new int[]{0, 4, 1, 5, 2, 6, 3};
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long conflict[][] = new long[6][6];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            conflict[op[a] - 1][b - 1] = 0;
            conflict[op[b] - 1][a - 1] = 0;
        }
        long[][] mPow_n_1 = mPow(conflict, n - 1);
        long ans = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                ans = (ans + mPow_n_1[i][j]) % MOD;
            }
        }
        System.out.println(ans * power(4, n) % MOD);
    }

    private static long power(long i, int n) {
        long ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) ans = (ans * i) % MOD;
            i = i * i % MOD;
            n >>= 1;
        }
        return ans;
    }

    private static long[][] mPow(long[][] conflict, int n) {
        long[][] e = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j)
                    e[i][j] = 1;
                else
                    e[i][j] = 0;
            }
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                e = mMul(e, conflict);
            }
            conflict = mMul(conflict, conflict);
            n >>= 1;
        }
        return e;
    }

    private static long[][] mMul(long[][] a, long[][] b) {
        long[][] ans = new long[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return ans;
    }


}
