package day20190506;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Date {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
//        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yy/MM/dd", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(sdf.format(date));
        System.out.println(calendar.get(Calendar.YEAR));

    }
}
