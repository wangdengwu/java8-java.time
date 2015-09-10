package java8.java.time;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import java.time.ZoneId;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ZoneIdTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void test_map_zoneIds() {
        ZoneId.getAvailableZoneIds().stream().sorted().forEach(name -> System.out.println(name));
        assertThat(outputCapture.toString(), containsString("Asia/Shanghai"));
    }
}
