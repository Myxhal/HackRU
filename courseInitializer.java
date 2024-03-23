import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class courseInitializer {

    public static List<courses> initializeAvailableCourses(String allCoursesPath, String takenCoursesPath) {
        Map<String, courses> allCourses = new HashMap<>();
        String[] computerScienceKeywords = {
            "Software Developer", "Web Developer", "Mobile Application Developer", "Database Administrator",
            "Systems Administrator", "Network Engineer", "Data Scientist", "Data Analyst",
            "Machine Learning Engineer", "AI Research Scientist", "Cybersecurity Analyst", "Information Security Analyst",
            "Cloud Solutions Architect", "DevOps Engineer", "Systems Analyst", "Business Analyst",
            "IT Project Manager", "Software Quality Assurance Tester", "User Experience Designer", "User Interface Designer",
            "Front-End Developer", "Back-End Developer", "Full Stack Developer", "Game Developer",
            "Embedded Systems Engineer", "Hardware Engineer", "Software Engineer", "Technical Support Specialist",
            "IT Consultant", "Cloud Engineer", "Data Engineer", "Game Developer",
            "Blockchain Developer", "CRM Developer", "ERP Developer", "Computer Vision Engineer",
            "NLP Engineer", "SEO Specialist", "Social Media Manager", "Content Manager",
            "IT Auditor", "Compliance Analyst", "Systems Engineer", "Network Architect",
            "Solutions Architect", "Technical Writer", "Product Manager", "Program Manager",
            "Scrum Master", "Agile Coach", "Research Scientist", "Quantitative Analyst",
            "Statistical Analyst", "Computer Programmer", "Quality Assurance Engineer", "Security Engineer",
            "Penetration Tester", "Ethical Hacker", "Digital Forensic Analyst", "Cloud Consultant",
            "IT Manager", "Chief Information Officer (CIO)", "Chief Technology Officer (CTO)", "Software Architect",
            "Infrastructure Engineer", "Release Manager", "Data Center Manager", "Database Developer",
            "E-commerce Analyst", "Network Security Engineer", "Cybersecurity", "Application Support Analyst",
            "Application Developer", "IT Operations Manager", "Data Privacy Officer", "UX Researcher",
            "Voice User Interface Designer", "Mobile UX Designer", "IoT Developer", "Augmented Reality Developer",
            "Virtual Reality Developer", "Site Reliability Engineer", "DevSecOps Engineer", "AI Architect",
            "Machine Learning Architect", "Data Governance Analyst", "Cloud Security Architect", "IT Procurement Specialist",
            "IT Service Manager", "Network Operations Center Engineer", "SAP Consultant", "Salesforce Developer",
            "Technical Sales Engineer", "Pre-sales Engineer", "Post-sales Engineer", "Technical Account Manager"
        };
        

        // Load all courses
        //Load all courses

        try (BufferedReader br = new BufferedReader(new FileReader(allCoursesPath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<String> subjects = Arrays.asList(values[1].split(";"));
                courses course = new courses(values[0], subjects, values[1], values[2], Integer.parseInt(values[3]));
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
