package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DateTimeFormatterTest {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_iso_date_format() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, 2, 14, 13, 22, 11);
        System.out.print(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));
        assertThat(outputCapture.toString(), is("2015-02-14T13:22:11"));
        System.out.print(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Test
    public void test_custom_date_format_patterns() {
        LocalDateTime localDateTime = LocalDateTime.of(2015, 8, 13, 22, 13, 22);
        System.out.print(localDateTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));
        assertThat(outputCapture.toString(), is("2015-08-13 22:13:22"));
    }

    @Test
    public void test_parse_date_string() {
        String dateString = "2015-02-14 22:23:14";
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
        System.out.print(localDateTime);
        assertThat(outputCapture.toString(), is("2015-02-14T22:23:14"));
    }
}
