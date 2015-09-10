package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

    @Test
    public void test_form_local_date_time() {
        LocalDate localDate = LocalDate.from(LocalDateTime.of(2015, 9, 10, 10, 10));
        System.out.print(localDate);
        assertThat(outputCapture.toString(), is("2015-09-10"));
    }

    @Test
    public void test_with_method() {
        LocalDate localDate = LocalDate.of(2008, 8, 8).withYear(2015).withMonth(10).withDayOfMonth(22);
        System.out.print(localDate);
        assertThat(outputCapture.toString(), is("2015-10-22"));
    }

    @Test
    public void test_get_method() {
        LocalDate localDate = LocalDate.of(2015, 11, 11);
        int year = localDate.getYear();
        String month = localDate.getMonth().name();
        int day = localDate.getDayOfMonth();
        System.out.print(year);
        System.out.print(month);
        System.out.print(day);
        assertThat(outputCapture.toString(), is("2015NOVEMBER11"));
    }

    @Test
    public void test_to_method() {
        LocalDate localDate = LocalDate.of(2015, 10, 10);
        System.out.print(localDate.toEpochDay());
        assertThat(outputCapture.toString(), is("16718"));
    }

    @Test
    public void test_at_method() {
        LocalDate localDate = Year.of(2015).atMonth(10).atDay(1);
        System.out.print(localDate);
        assertThat(outputCapture.toString(), is("2015-10-01"));
    }

    @Test
    public void test_plus_method() {
        LocalDate localDate = LocalDate.of(2015, 10, 1);
        System.out.print(localDate.plusYears(1).plusMonths(1).plusDays(1));
        assertThat(outputCapture.toString(), is("2016-11-02"));
    }

    @Test
    public void test_minus_method() {
        LocalDate localDate = LocalDate.of(2015, 10, 10);
        System.out.print(localDate.minusYears(1).minusMonths(1).minusWeeks(1).minusDays(1));
        assertThat(outputCapture.toString(), is("2014-09-02"));
    }

    @Test
    public void test_until_method() {
        System.out.print(LocalDate.of(2015, 9, 10).until(LocalDate.of(2015, 10, 1), ChronoUnit.DAYS));
        assertThat(outputCapture.toString(), is("21"));
    }
}
