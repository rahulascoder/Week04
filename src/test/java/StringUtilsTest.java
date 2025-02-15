import static org.junit.jupiter.api.Assertions.*;

import com.java_junit.StringUtils;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    //Creating stringUtils object of class StringUtils
    StringUtils stringUtils = new StringUtils();

    //Testing reverse
    @Test
    void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
        assertEquals("racecar", stringUtils.reverse("racecar"));
    }

    //Testing palindrome
    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    //Testing Upper case
    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
    }
}
