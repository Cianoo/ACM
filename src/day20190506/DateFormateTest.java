package day20190506;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormateTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        Calendar cale = Calendar.getInstance();
//        System.out.println(cale);
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM,yyyy",
                Locale.ENGLISH);

        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(cale.getTime()));

        SimpleDateFormat input = new SimpleDateFormat("dd/mm/yy");
        Date date1 = null;

    }
}
