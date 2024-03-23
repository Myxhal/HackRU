import java.util.List;

public class main {
    public static void main(String[] args) {
        String allCoursesPath = "courses.csv";
        String takenCoursesPath = "courses.csv";
        List<courses> availableCourses = courseInitializer.initializeAvailableCourses(allCoursesPath, takenCoursesPath);
     }
}
