/**
 * This class represents a student with an ID number and name.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 01 May 2025
 */
public class Student {
    private int id;
    private String name;

    /**
     * Constructs a new Student with the given ID number and name.
     * @param id the ID of the student
     * @param name the name of the student
     */
    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * Returns the name of the student.
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the student.
     * @return the ID of the student
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "(" + id + ": " + name + ")";
    }
}
