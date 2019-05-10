package ACM;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemF_FullmetalAlchemist {
    public static void main(String[] args) {
        int caseNumber = 0;
        int totalNumber = 0;    // 1 < tatalNumber < 10
        int outputNumber;   //输出数字个数

        //输入test cases 个数
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int a = Integer.parseInt(scanner.next());
            if (a < 1 || a > 10) {
                System.out.println("1 < number < 10");
            } else {
                caseNumber = a;
            }
        } else {
            System.out.println("enter a number");
        }

        //输入 number个数
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.hasNextInt()) {
            totalNumber = Integer.parseInt(scanner1.next());
        } else {
            System.out.println("please enter a number");
        }


        //储存数组
        int[] a = new int[totalNumber];
        Scanner scanner2 = new Scanner(System.in);
        String s = scanner2.nextLine();

        for (int i = 0; i < totalNumber; i++) {
            String s1 = s.split(" ")[i];
            if (ifNum(s1)) {
                a[i] = Integer.parseInt(s1);
            } else {
                System.out.println("please enter " + totalNumber + " numbers");
            }
        }

        Arrays.sort(a); // 数组从小到大排序
        outputNumber = totalNumber / 2; //输出个数
        int maxValue = 0;

        for (int i = 0; i < outputNumber; i++) { //循环输出n/2个结果
            int length = (i + 1) * 2;

            for (int j = 0; j < totalNumber - length + 1; j++) { //重新分配数组
                int[] newArray = new int[length];

                for (int k = 0, m = j; k < length; k++, m++) {   //数组赋值
                    newArray[k] = a[m];
                }

                int k = getValue(newArray);
                if (maxValue < k) {
                    maxValue = k;
                }

            }
            System.out.print(maxValue + " ");
        }


    }

    /**
     * 判断目标字符串是否为数字
     *
     * @param str
     * @return
     */
    private static boolean ifNum(String str) {
        return str != null && str.matches("^[0-9]+$");
    }


    /**
     * 得值
     *
     * @param ints 升序数组
     * @return
     */
    private static int getValue(int[] ints) {
        int length = ints.length;
        int x = (ints[length - 1] - ints[0] + 1) / 2;
        int max = 0;
        int min = 0;

        for (int i = 0; i < x; i++) {
            min += ints[i];
        }
        for (int i = length - 1; i >= length - x; i--) {
            max += ints[i];
        }

        return max - min;
    }
}
