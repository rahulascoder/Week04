import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.java_junit.Division;

public class DivisionTest{
    @Test
    void testDivideByZero() {
        Division calculator = new Division();

        // Verifying ArithmeticException is thrown when dividing by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

        // Verifying exception message
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
