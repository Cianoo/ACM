package ACM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author huangsuixin
 * @date 2019/05/07
 */
public class BeyondTheBoundry {

    private static final String[] names = {"Kanbara Akihito", "Kuriyama Mirai", "Nase Hiroomi", "Nase Mitsuki"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t;
        t = scanner.nextInt();

        String[] strings = new String[t];
        for (int i = 0; i < t; i++) {
            strings[i] = scanner.next();
        }


        // 存储结果的
        List<List<String>> result = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            result.add(new ArrayList<>(4));
            for (int j = 0; j < 4; j++) {
                if (isSubSequence(strings[i], names[j].replace(" ", ""))) {
                    result.get(i).add(names[j]);
                }
            }
        }

        for (List<String> strings1 : result) {
            System.out.println(strings1.size());
            for (String aStrings1 : strings1) {
                System.out.println(aStrings1);
            }

        }
    }

    /**
     * 判断s是否为target的有序子序列
     *
     * @param s
     * @param target
     * @return
     */
    private static boolean isSubSequence(String s, String target) {
        if (s == null || target == null) {
            return false;
        }
        if (s.length() > target.length()) {
            return false;
        }

        int i = 0, j = 0;
        int count = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i++;
                j++;
                count++;

            } else {
                j++;
            }
        }
        return count == s.length();
    }
}