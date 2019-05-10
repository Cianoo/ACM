package ACM;

import java.util.Scanner;

/**
 * @author huangsuixin
 * @date 2019/05/10 13:23
 * @description //TODO
 */
public class ProblemLuckyNumber {

    private static String[] strArr;
    private static String targetStr;
    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        // test case
        int t;

        t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            runTestCase();
        }

    }


    private static void runTestCase() {
        // 带判定字符串长度
        int targetStrLength;
        // 字符串集合中字符个数
        int strArrNum;

        // 输入判定字符串长度
        targetStrLength = scanner.nextInt();

        // 输入字符串集合中字符串个数
        strArrNum = scanner.nextInt();

        // 输入判定字符串
        targetStr = scanner.next();

        // 输入字符串集合
        strArr = new String[strArrNum];
        strArr = scanner.next().split("/");

        for (int i = 1; i <= targetStrLength; i++) {
            int result = getResult(targetStr.substring(0, i));
            System.out.print(result + "\t");
        }
    }

    private static int getResult(String s) {
        if (s.length() == 0) {
            return 1;
        }
        int count = 0;
        for (String string : strArr) {
            if (s.startsWith(string)) {
                count += getResult(s.substring(string.length()));
            }
        }
        return count;
    }

}
