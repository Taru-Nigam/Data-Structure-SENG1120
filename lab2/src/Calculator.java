import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String entry, continueCalc;
        double v1, v2, sum, sub, mult, div;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st No.: ");
        v1 = scanner.nextDouble();
        System.out.println("1st Number is: " + v1);
        System.out.println("Enter 2nd No.: ");
        v2 = scanner.nextDouble();
        System.out.println("2nd Number is: " + v2);

        boolean validOption = false;
        while(!validOption){
            System.out.println("Please select an option: ");
            System.out.println("1.SUM\n2.SUB\n3.MULT\n4.DIV\n");
            entry = scanner.next();
            switch (entry.toUpperCase()){
                case "1":
                    sum = v1 + v2;
                    System.out.println("The Sum of " + v1 + " and " + v2 + "is: ");
                    System.out.println(sum);
                    validOption = true;
                    break;
                case "2":
                    sub = v1 - v2;
                    System.out.println("The Subtraction of " + v1 + " and " + v2 + "is: ");
                    System.out.println(sub);
                    validOption = true;
                    break;
                case "3":
                    mult = v1 * v2;
                    System.out.println("The Multiplication of " + v1 + " and " + v2 + "is: ");
                    System.out.println(mult);
                    validOption = true;
                    break;
                case "4":
                    div = v1 + v2;
                    System.out.println("The Division of " + v1 + " and " + v2 + "is: ");
                    System.out.println(div);
                    validOption = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        System.out.println("Do you want to use the calculator again? (Y/N): ");
        continueCalc = scanner.next();

        while(continueCalc.equalsIgnoreCase("Y"));
        System.out.println("Calculator exited.");
        scanner.close();
    } 
}
