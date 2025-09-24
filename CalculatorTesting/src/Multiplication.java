/**
 * Performs multiplication of two numbers. This class implements the BinaryOperation interface.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 6 Mar 2025
 */
public class Multiplication implements BinaryOperation {

    /**
     * Applies the multiplication operation to the given arguments.
     * 
     * @param a The left side of the operation.
     * @param b The right side of the operation.
     * @return The product of a and b.
     */
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}