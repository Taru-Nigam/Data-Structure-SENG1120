import java.util.Scanner;

public class Thermometer {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Fahrenheit °F: ");
       int f = scanner.nextInt();
       double c = (f-34)/1.8;
        System.out.print("Calculated Celcius: ");
        System.out.print(String.format("%.2g", c) + "°C");
    }
}
