package ACM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ProblemE_Ever17 {

    public static void main(String[] args) throws ParseException {
        int EXAMPLE_NUMBER = 0;
        String date_format = "MM/dd/yy";
        String date_format1 = "yy/MM/dd";

        ProblemE_Ever17 problemEEver17 = new ProblemE_Ever17();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int num = Integer.parseInt(scanner.next());
            if (num > 0 && num < 5) {
                EXAMPLE_NUMBER = num;
            } else {
                System.out.println("请输入[1,5]之间的数字");
            }
        } else {
            System.out.println("请输入数字");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(date_format);   //设置输入时间格式
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(date_format1, Locale.ENGLISH);  //设置输入时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM,yyyy", //设置输出时间格式
                Locale.ENGLISH);

        Date[] date = new Date[EXAMPLE_NUMBER];
        String[] str = new String[EXAMPLE_NUMBER];

        for (int i = 0; i < EXAMPLE_NUMBER; i++) {
            Scanner scanner1 = new Scanner(System.in);
            String datee = scanner1.next();

            if ((   problemEEver17.checkDateFormat(datee, date_format)
                    ||
                    problemEEver17.checkDateFormat(datee, date_format1))) {
                str[i] = datee;
            } else {
                System.out.println("日期格式不正确（19/05/09 or 05/09/19）");
            }
        }

        for (int i = 0; i < EXAMPLE_NUMBER; i++) {
            int b = Integer.parseInt(str[i].split("/")[0]);

            if (b > 12) {

                date[i] = simpleDateFormat1.parse(str[i]);
                System.out.println(sdf.format(date[i]));
            } else {
                date[i] = simpleDateFormat.parse(str[i]);           //格式化为MM/dd/yy
                Date date1 = simpleDateFormat1.parse(str[i]);       //格式化为yy/MM//dd
                long diff = date1.getTime() - date[i].getTime();        //相差毫秒数
                long days = problemEEver17.abs(diff) / (1000 * 60 * 60 * 24); //相差天数

                System.out.println(days);
            }
        }
    }

    /**
     * 取绝对值
     *
     * @param a
     * @return
     */
    private long abs(long a) {
        return a > 0 ? a : -a;
    }


    /**
     * 判断输入日期格式是否正确
     *
     * @param date
     * @param format 目标格式
     * @return
     */
    private boolean checkDateFormat(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        simpleDateFormat.setLenient(false);

        try {
            simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}


