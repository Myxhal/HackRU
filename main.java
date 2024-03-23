public class main {
    public static void main(String[] args) {
        String allCoursesPath = "path/to/all/courses.csv";
        String takenCoursesPath = "path/to/taken/courses.csv";
        List<courses> availableCourses = courseInitializer.initializeAvailableCourses(allCoursesPath, takenCoursesPath);
     }
}
