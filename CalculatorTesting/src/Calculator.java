/**
 * A calculator that performs binary operations.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 6 Mar 2025
 */
public class Calculator {
    /**
     * The binary operation to perform.
     */
    private BinaryOperation operation;

    /**
     * Sets the binary operation to perform.
     * 
     * @param operation The binary operation to perform.
     */
    public void setOperation(BinaryOperation operation) {
        this.operation = operation;
    }

    /**
     * Calculates the result of the binary operation on the given arguments.
     * 
     * @param a The left side of the operation.
     * @param b The right side of the operation.
     * @return The result of the operation.
     */
    public double calculate(double a, double b) {
        if (operation == null) {
            throw new IllegalStateException("Operation not set.");
        }
        return operation.apply(a, b);
    }
}