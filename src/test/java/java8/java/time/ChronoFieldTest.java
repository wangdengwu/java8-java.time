package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChronoFieldTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_get_method() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, 10, 1, 20, 10, 30);
        System.out.print(localDateTime.get(ChronoField.YEAR) + "-");
        System.out.print(localDateTime.get(ChronoField.MONTH_OF_YEAR) + "-");
        System.out.print(localDateTime.get(ChronoField.DAY_OF_MONTH) + "(");
        System.out.print(DayOfWeek.of(localDateTime.get(ChronoField.DAY_OF_WEEK)) + ")");
        System.out.print(localDateTime.get(ChronoField.HOUR_OF_DAY) + ":");
        System.out.print(localDateTime.get(ChronoField.MINUTE_OF_HOUR) + ":");
        System.out.print(localDateTime.get(ChronoField.SECOND_OF_MINUTE));
        assertThat(outputCapture.toString(), is("2015-10-1(THURSDAY)20:10:30"));

        System.out.println("");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime one_month_ago = now.minus(1, ChronoUnit.MONTHS);
        System.out.println(System.currentTimeMillis());
        System.out.print(one_month_ago.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
