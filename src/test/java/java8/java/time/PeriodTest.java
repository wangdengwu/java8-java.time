package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PeriodTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_period_method() {
        Period period = Period.ofMonths(1);
        LocalDate localDate = LocalDate.of(2015, 10, 1);
        localDate = localDate.minus(period);
        System.out.print(localDate);
        assertThat(outputCapture.toString(), is("2015-09-01"));
    }
}
