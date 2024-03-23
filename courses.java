import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Course {
    private String courseId;
    private List<String> subjects;
    private String courseName;
    private String description;
    private double numberOfCredits;
    private boolean taken;

    public Course(String courseId, List<String> subjects, String courseName, String description, double numberOfCredits) {
        this.courseId = courseId;
        this.subjects = subjects;
        this.courseName = courseName;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
        this.taken = false;
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

    public boolean isTaken () {return taken;}
    public void setTaken (boolean taken) {this.taken = taken;}
}

public class CourseInitializer {
    public static List<Course> initializeAvailableCourses(String allCoursesPath, String takenCoursesPath) {
        Map<String, Course> allCourses = new HashMap<>();

        // Load all courses
        try (BufferedReader br = new BufferedReader(new FileReader(allCoursesPath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> subjects = Arrays.asList(values[1].split(";"));
                Course course = new Course(values[0], subjects, values[2], values[3], Integer.parseInt(values[4]));
                allCourses.put(course.getCourseId(), course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mark taken courses
        try (BufferedReader br = new BufferedReader(new FileReader(takenCoursesPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the taken courses file contains only the course IDs
                if(allCourses.containsKey(line.trim())) {
                    allCourses.get(line.trim()).setTaken(true);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Filter out taken courses and return the list
        List<Course> availableCourses = new ArrayList<>();
        for (Course course : allCourses.values()) {
            if (!course.isTaken()) {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }
}

public class Main {
    public static void main(String[] args) {
        String allCoursesPath = "path/to/all/courses.csv";
        String takenCoursesPath = "path/to/taken/courses.csv";
        List<Course> availableCourses = CourseInitializer.initializeAvailableCourses(allCoursesPath, takenCoursesPath);
     }
    }

