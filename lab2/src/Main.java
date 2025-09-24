import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<AbstractShape> shapeBox= new Box<>();

        while (true){
            System.out.println("Choose a shape to create: ");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }
            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter radius of the circle: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                        if (radius <= 0) {
                            System.out.println("Radius must be positive.");
                            break;
                        }
                        shapeBox.setItem(new Circle(radius));
                        break;
                    case 2:
                        System.out.print("Enter length of the rectangle: ");
                        double length = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter width of the rectangle: ");
                        double width = Double.parseDouble(scanner.nextLine());
                        if (length <= 0 || width <= 0) {
                            System.out.println("Length and width must be positive.");
                            break;
                        }
                        shapeBox.setItem(new Rectangle(length, width));
                        break;
                    case 3:
                        System.out.print("Enter side a of the triangle: ");
                        double a = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter side b of the triangle: ");
                        double b = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter side c of the triangle: ");
                        double c = Double.parseDouble(scanner.nextLine());
                        if (a <= 0 || b <= 0 || c <= 0) {
                            System.out.println("All sides must be positive.");
                            break;
                        }
                        shapeBox.setItem(new Triangle(a, b, c));
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                        continue;
                }
                AbstractShape shape = shapeBox.getItem();
                System.out.println(shape.getName());
                shape.display();
            } catch (InvalidShapeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
            }
            System.out.println(); // Blank line for readability
        }
        scanner.close();
    }
}


//        shapeBox.setItem(new Circle(5));
//        AbstractShape boxShape = shapeBox.getItem();
//        System.out.println(boxShape.getName());
//        boxShape.display();
//
//        shapeBox.setItem(new Rectangle(4, 6));
//        boxShape = shapeBox.getItem();
//        System.out.println(boxShape.getName());
//        boxShape.display();

//        AbstractShape abstractShape = new Circle(5);
//        System.out.println(abstractShape.getName());
//        abstractShape.display();
//
//        abstractShape = new Rectangle(4, 6);
//        System.out.println(abstractShape.getName());
//        abstractShape.display();

//        Shape shape = new Circle(5);
//        System.out.println("Circle Area: " + shape.area());
//        System.out.println("Circle Perimenter: " + shape.perimeter());
//
//        shape = new Rectangle(4, 6);
//        System.out.println("Rectangle Area: " + shape.area());
//        System.out.println("Rectangle Perimeter: " + shape.perimeter());
//    }
//}