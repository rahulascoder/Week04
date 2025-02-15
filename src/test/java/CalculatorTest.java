import com.java_junit.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator = new Calculator();

    //Test case for add method
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }
    //Test case for subtract method
    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
    }
    //Test case for multiply method
    @Test
    void testMultiply() {
        assertEquals(12, calculator.multiply(4, 3));
    }
    //Test case for divide method
    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }
    //Test case for exception handling method
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
