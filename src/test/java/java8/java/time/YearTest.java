package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.Period;
import java.time.Year;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class YearTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_leap_year() {
        Year year = Year.of(2014);
        System.out.print(year.isLeap());
        year = year.plus(Period.ofYears(2));
        System.out.print(year.isLeap());
        assertThat(outputCapture.toString(), is("falsetrue"));
    }
}
