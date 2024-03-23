import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseInitializer {
    public static List<Course> initializeCoursesFromTranscript(String filePath) {
        
        Map<String, Course> courseMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> subjects = Arrays.asList(values[1].split(";"));
                Course course = new Course(values[0], subjects, values[2], values[3], Double.parseDouble(values[4]));
                courseMap.putIfAbsent(course.getCourseId(), course); // Prevent duplicates based on courseID
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(courseMap.values());
    }
}

public class Course {
    private String courseId;
    private List<String> subjects;
    private String courseName;
    private String description;
    private double numberOfCredits;

    public Course(String courseId, List<String> subjects, String courseName, String description, double numberOfCredits) {
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

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getNumberOfCredits() { return numberOfCredits; }
    public void setNumberOfCredits(double numberOfCredits) { this.numberOfCredits = numberOfCredits; }
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

