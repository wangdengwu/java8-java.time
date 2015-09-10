package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TemporalAdjustersTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_next_method() {
        LocalDate localDate = LocalDate.of(2015, 9, 10);
        LocalDate next_monday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.print(next_monday);
        assertThat(outputCapture.toString(), is("2015-09-14"));
    }

    @Test
    public void test_last_day_of_month() {
        LocalDate localDate = LocalDate.of(2015, 2, 12);
        LocalDate last_day_of_month = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.print(last_day_of_month);
        assertThat(outputCapture.toString(), is("2015-02-28"));
    }

    @Test
    public void test_custom_adjuster() {
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.ofDateAdjuster((LocalDate localDate) -> localDate.plusMonths(2).plusWeeks(1));
        LocalDate localDate = LocalDate.of(2015, 5, 22);
        LocalDate newDay = localDate.with(temporalAdjuster);
        System.out.print(newDay);
        assertThat(outputCapture.toString(), is("2015-07-29"));
    }
}
