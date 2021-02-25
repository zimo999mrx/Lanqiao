package AlgorithmIsSoBeautiful._6_数学问题;

import java.util.Scanner;

/**
 * _6_1_天平称重
 *
 * @author zixi
 * @version 1.0
 * @date 21/02/25 下午 8:18
 */
public class _6_1_天平称重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = Integer.toString(sc.nextInt(), 3);
        int[] arr = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            arr[i + 1] = s.charAt(i) - '0';
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == 2) {
                arr[i] = -1;
                arr[i - 1]++;
            }
            if (arr[i] == 3) {//22的这种情况1 0 -1
                arr[i] = 0;
                arr[i - 1] = 1;
            }
        }
        boolean isFirst = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (isFirst) {
                    System.out.print((int) Math.pow(3, arr.length - i - 1));
                    isFirst = false;
                } else {
                    System.out.print("+" + (int) Math.pow(3, arr.length - i - 1));
                }
            }
            if (arr[i] == -1) {
                System.out.print("-" + (int) Math.pow(3, arr.length - i - 1));
            }
        }
    }
}
