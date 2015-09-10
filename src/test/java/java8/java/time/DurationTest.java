package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DurationTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_of_method() {
        Duration.ofHours(2);
        Duration.ofMinutes(2);
        Duration.ofSeconds(2);
        System.out.print(Duration.ofDays(2));
        System.out.print(Duration.ofHours(2));
        System.out.print(Duration.ofMinutes(2));
        System.out.print(Duration.ofSeconds(2));
        assertThat(outputCapture.toString(), is("PT48HPT2HPT2MPT2S"));
    }
}
