package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ClockTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_clock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        Instant instant = Instant.now(clock);
        System.out.println(instant.toEpochMilli());
        System.out.println(clock.instant());
        LocalDateTime localDateTime = LocalDateTime.now(clock);
        System.out.println(localDateTime);
        System.out.println(ZonedDateTime.now(clock).toInstant().toEpochMilli());
    }
}
