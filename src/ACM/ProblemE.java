package ACM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ProblemE {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        int EXAMPLE_NUMBER = Integer.parseInt(scanner.next());  //获取用例数量


//        if (scanner.next() != null && scanner.next().matches("^[0-9]+$")){
//            EXAMPLE_NUMBER = Integer.parseInt(scanner.next());
//            if (EXAMPLE_NUMBER < 1 || EXAMPLE_NUMBER > 6 ){
//                System.out.println("1≤T≤5!");
//            }
//        }else {
//            System.out.println("please enter a number!1≤number≤5");
//        }


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");   //设置输入时间格式
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yy/MM/dd", Locale.ENGLISH);  //设置输入时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM,yyyy", //设置输出时间格式
                Locale.ENGLISH);

        Date[] date = new Date[EXAMPLE_NUMBER];
        String[] str = new String[EXAMPLE_NUMBER];

        for (int i = 0; i < EXAMPLE_NUMBER; i++) {
            Scanner scanner1 = new Scanner(System.in);

            str[i] = scanner1.next();
        }

        for (int i = 0; i < EXAMPLE_NUMBER; i++) {

            int b = Integer.parseInt(str[i].split("/")[0]);
            if (b > 12) {

                date[i] = simpleDateFormat1.parse(str[i]);
                System.out.println(sdf.format(date[i]));
            } else {

                date[i] = simpleDateFormat.parse(str[i]);
                Date date1 = simpleDateFormat1.parse(str[i]);

                ProblemE problemE = new ProblemE();
                long diff = date1.getTime() - date[i].getTime();
                long days = problemE.abs(diff) / (1000 * 60 * 60 * 24);

                System.out.println(days);
            }
        }
    }

    private long abs(long a) {
        return a > 0 ? a : -a;
    }
}


