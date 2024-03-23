//Code for the process of turning data into course objects that the AI can access
 

public class courses{
    private String courseId;
    private String courseName;
    private int credits;
    private String descript;
    private String[] subjects = {""};

    public courses(String courseId, String[] subjects, String courseName, String descript, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.descript = descript;
        this.subjects = subjects;
    }

    // Getters and setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}

