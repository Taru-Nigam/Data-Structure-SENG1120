/**
 * Performs subtraction of two numbers. This class implements the BinaryOperation interface.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 6 Mar 2025
 */
public class Subtraction implements BinaryOperation {

    /**
     * Applies the subtraction operation to the given arguments.
     * 
     * @param a The left side of the operation.
     * @param b The right side of the operation.
     * @return The difference of a and b.
     */
    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}