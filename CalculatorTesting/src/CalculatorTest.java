import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        calculator.setOperation(new Addition());
        assertEquals(8, calculator.calculate(5, 3));
    }
    @Test
    void testSubtraction(){
        calculator.setOperation(new Subtraction());
        assertEquals(2, calculator.calculate(5,3));
    }
    @Test
    void testMultiplication(){
        calculator.setOperation(new Multiplication());
        assertEquals(15, calculator.calculate(5,3));
    }
    @Test
    void testDivision(){
        calculator.setOperation(new Division());
        assertEquals(2, calculator.calculate(6,3));
    }
    @Test
    void testDivisionByZero() {
        calculator.setOperation(new Division());
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(5, 0));
    }
}
