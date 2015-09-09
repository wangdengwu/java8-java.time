package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by dwwang on 9/9/15.
 */
public class LocalDateTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_normal_of_method() {
        LocalDate normal = LocalDate.of(2015, 8, 21);
        System.out.print(normal);
        assertThat(outputCapture.toString(), is("2015-08-21"));
    }

    @Test
    public void test_month_enum_of_method() {
        LocalDate mouthEnum = LocalDate.of(2015, Month.FEBRUARY, 28);
        System.out.print(mouthEnum);
        assertThat(outputCapture.toString(), is("2015-02-28"));
    }

    @Test
    public void test_epoch_day_of_method() {
        LocalDate ofEpochDay = LocalDate.ofEpochDay(365);
        System.out.print(ofEpochDay);
        assertThat(outputCapture.toString(), is("1971-01-01"));
    }

    @Test
    public void test_year_day_of_method() {
        LocalDate ofYearDay = LocalDate.ofYearDay(2015, 139);
        System.out.print(ofYearDay);
        assertThat(outputCapture.toString(), is("2015-05-19"));
    }

}
