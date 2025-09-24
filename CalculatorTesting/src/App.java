public class App {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        calculator.setOperation(new Addition());
        System.out.println("Addition: " + calculator.calculate(5, 3));

        calculator.setOperation(new Subtraction());
        System.out.println("Subtraction: " + calculator.calculate(5, 3));

        calculator.setOperation(new Multiplication());
        System.out.println("Multiplication: " + calculator.calculate(5, 3));

        calculator.setOperation(new Division());
        System.out.println("Division: " + calculator.calculate(10, 2.5));
    }
}
