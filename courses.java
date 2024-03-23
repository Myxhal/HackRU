import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class courses{
    private String courseId;
    private List<String> subjects;
    private String courseName;
    private String description;
    private double numberOfCredits;
    private boolean taken;

    public courses(String courseId, String courseName, String description, double numberOfCredits) {
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

