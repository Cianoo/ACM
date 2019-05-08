package ACM;

import java.util.Scanner;

/**
 * @author huangsuixin
 * @date 2019/05/08 18:38
 */
public class Harmony {
    public static void main(String[] args) {

        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            int[] cases = new int[2];

            for (int j = 0; j < 2; j++) {
                cases[j] = scanner.nextInt();
            }
            result[i] = getResult(cases[0], cases[1]);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }

    private static int getResult(int a, int b) {
        return a + b + gcd(a, b);
    }

    /**
     * 求a、b的最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
