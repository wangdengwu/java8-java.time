package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InstantTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_of_method() {
        Instant instant = Instant.ofEpochSecond(1);
        System.out.print(instant);
        assertThat(outputCapture.toString(), is("1970-01-01T00:00:01Z"));
    }

    @Test
    public void test_minus_30_days() {
        long now = Instant.now().toEpochMilli();
        long before_30 = Instant.now().minus(Duration.ofMillis(30)).toEpochMilli();
        assertThat(now, is(before_30 + 30L));
    }
}
