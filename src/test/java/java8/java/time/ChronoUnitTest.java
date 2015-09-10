package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChronoUnitTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_between() {
        LocalDateTime old = LocalDateTime.of(2015, 8, 15, 10, 22, 32);
        LocalDateTime hew = LocalDateTime.of(2015, 9, 10, 10, 22, 33);
        System.out.println(ChronoUnit.MONTHS.between(old, hew));
        System.out.println(ChronoUnit.DAYS.between(old, hew));
        System.out.println(ChronoUnit.HOURS.between(old, hew));
        System.out.println(ChronoUnit.MINUTES.between(old, hew));
        System.out.println(ChronoUnit.SECONDS.between(old, hew));
        assertThat(outputCapture.toString(), is(
                "0\n" +
                        "26\n" +
                        "624\n" +
                        "37440\n" +
                        "2246401\n"));
    }
}
