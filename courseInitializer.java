public class courseInitializer {
    public static List<courses> initializeAvailableCourses(String allCoursesPath, String takenCoursesPath) {
        Map<String, courses> allCourses = new HashMap<>();

        // Load all courses
        try (BufferedReader br = new BufferedReader(new FileReader(allCoursesPath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> subjects = Arrays.asList(values[1].split(";"));
                Course course = new courses(values[0], subjects, values[2], values[3], Integer.parseInt(values[4]));
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
        List<courses> availableCourses = new ArrayList<>();
        for (courses course : allCourses.values()) {
            if (!course.isTaken()) {
                availableCourses.add(course);
            }
        }

        return availableCourses;
    }
}
