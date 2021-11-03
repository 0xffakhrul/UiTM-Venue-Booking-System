import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;


/**
 * Write a description of class Time here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Time
{
    public static void main(String args[]){
        String time1 = "2255";
        String time2 = "2305";

        SimpleDateFormat format = new SimpleDateFormat("HHmm");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
    }
}
