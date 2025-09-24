import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] grades = new int[numStudents];
        for(int i = 0; i < numStudents; i++){
            System.out.println("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        int sum = 0;
        for(int grade : grades){
            sum+=grade;
        }
        double average = (double) sum/numStudents;
        System.out.println("Average grade: " + average);

        scanner.close();
        }
    }