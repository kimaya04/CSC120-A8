import java.util.ArrayList;

public class Student {

    // Attributes 
    private String name; 
    private String id; 
    private int classYear; 
    private ArrayList<Course> classes; 

    /* Constructor */
    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<Course>(); 
    }

    /* Getter
     * Returns student name.
     * @return name
     */
    public String getName() {
        return this.name; 
    }

    /**
     * Converts student information to readable string.
     * @return string representation of the Student object
     */
    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        ab.classes.add(csc120);
        System.out.println(ab.classes);
    }
    
}
