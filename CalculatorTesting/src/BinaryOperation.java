/**
 * Interface for binary operations.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 6 Mar 2025
 */
public interface BinaryOperation {

    /**
     * Applies the binary operation to the given arguments.
     * 
     * @param a The left side of the operation.
     * @param b The right side of the operation.
     * @return The result of the operation.
     */
    double apply(double a, double b);
}