//Code for the process of turning data into course objects that the AI can access
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Course {
    private String courseId;
    private List<String> subjects;
    private String courseName;
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    private String description;
    private int numberOfCredits;

    public Course(String courseId, List<String> subjects, String courseName, String description, int numberOfCredits) {
=======
>>>>>>> Stashed changes
    private double credits;
    private String descript;
    private String[] subjects = {""};

    public courses(String courseId, String[] subjects, String courseName, String descript, double credits) {
<<<<<<< Updated upstream
=======
>>>>>>> 3855244b5ce596b3d89b36619fec30b1757bbe5c
>>>>>>> Stashed changes
        this.courseId = courseId;
        this.subjects = subjects;
        this.courseName = courseName;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    // Getters and setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

<<<<<<< Updated upstream
    public double getCredits() { return credits; }
    public void setCredits(double credits) { this.credits = credits; }
    public static void main(String args[]){
        
    
    }
}


=======
<<<<<<< HEAD
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNumberOfCredits() { return numberOfCredits; }
    public void setNumberOfCredits(int numberOfCredits) { this.numberOfCredits = numberOfCredits; }
}


public class CourseInitializer {

    public static List<Course> initializeCoursesFromTranscript(String filePath) {

        Map<String, Course> courseMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> subjects = Arrays.asList(values[1].split(";"));
                Course course = new Course(values[0], subjects, values[2], values[3], Integer.parseInt(values[4]));
                courseMap.putIfAbsent(course.getCourseId(), course); // Prevent duplicates based on courseID
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(courseMap.values());
    }
}

public class Main {
    public static void main(String[] args) {
        String filePath = "path/to/your/courses.csv";
        List<Course> courses = CourseInitializer.initializeCoursesFromTranscript(filePath);

        // Example usage
        for (Course course : courses) {
            System.out.println(course.getCourseName() + " (" + course.getNumberOfCredits() + " credits): " + course.getDescription());
        }
    }
}





=======
    public double getCredits() { return credits; }
    public void setCredits(double credits) { this.credits = credits; }
    public static void main(String args[]){
        
    
    }
}


>>>>>>> 3855244b5ce596b3d89b36619fec30b1757bbe5c
>>>>>>> Stashed changes

