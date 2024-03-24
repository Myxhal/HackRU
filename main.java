import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        String allCoursesPath = "courses.csv";
        String takenCoursesPath = "courses.csv";
        List<courses> availableCourses = courseInitializer.initializeAvailableCourses(allCoursesPath, takenCoursesPath);
     }
}
