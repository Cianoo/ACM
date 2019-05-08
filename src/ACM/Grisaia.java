package ACM;

import java.util.Scanner;

/**
 * @author huangsuixin
 * @date 2019/05/08 18:38
 */
public class Grisaia {

    public static void main(String[] args) {

        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(getResult(n[i]));
        }
    }

    private static int getResult(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count += n % (i * j);
            }
        }
        return count;

    }


}
