package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisabledTests {

    @Test
    @Disabled
    void disabledTest1() {
        assertTrue(false);
    }

    @Test
    @Disabled()
    void disabledTest2() {
        assertTrue(false);
    }
}
