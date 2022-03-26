package uitests.assistants;

import io.grpc.internal.JsonUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFormator {

    public static String getCurrentDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }

    public static String getMonthAgoDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -30);
        return dateFormat.format(calendar.getTime());
    }

    public static String getThreeMonthAgoDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -90);
        return dateFormat.format(calendar.getTime());
    }

    public static String getCurrentDateOnlyString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
