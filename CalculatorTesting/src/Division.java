/**
 * Performs division of two numbers. This class implements the BinaryOperation interface.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 6 Mar 2025
 */
public class Division implements BinaryOperation {

    /**
     * Applies the division operation to the given arguments.
     * 
     * @param a The left side of the operation.
     * @param b The right side of the operation.
     * @return The result of the division.
     */
    @Override
    public double apply(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}