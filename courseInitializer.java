import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class courseInitializer {

    private static final String[] COMPUTER_SCIENCE_KEYWORDS = {
    "Software", "Web", "Mobile", "Database", "Systems", "Network", "Data", "Machine Learning",
    "AI", "Cybersecurity", "Cloud", "DevOps", "UX", "UI", "Frontend", "Backend", "Fullstack",
    "Embedded", "Hardware", "Engineering", "Technical", "Consulting", "Game", "Blockchain",
    "CRM", "ERP", "Vision", "NLP", "SEO", "Social Media", "Content", "Audit", "Compliance",
    "Architecture", "Writing", "Management", "Agile", "Research", "Analytics", "Programming",
    "Quality", "Security", "Forensics", "Infrastructure", "E-commerce", "Privacy", "IoT",
    "Reality", "Reliability", "Governance", "Procurement", "Service", "Operations", "SAP",
    "Salesforce", "Sales", "Support", "Python", "Java", "JavaScript", "C++", "C#", "Ruby",
    "PHP", "Swift", "Kotlin", "SQL", "TypeScript", "Scala", "Go", "Rust", "Perl", "MATLAB",
    "R", "DevSecOps", "Fintech", "Quant", "Big Data", "Hadoop", "Spark", "Docker", "Kubernetes",
    "Git", "GitHub", "Bitbucket", "JIRA", "Scrum", "Kanban", "Microservices", "API",
    "REST", "GraphQL", "MVC", "SOLID", "OOP", "Functional", "Reactive", "Event-Driven",
    "TDD", "BDD", "CI/CD", "Automation", "Performance", "Scalability", "High Availability",
    "Cloud Computing", "AWS", "Azure", "GCP", "OpenStack", "Virtualization", "Orchestration",
    "Cryptography", "Blockchain", "Smart Contracts", "AR", "VR", "MR", "IoT", "Edge Computing",
    "Quantum Computing", "Data Mining", "Data Visualization", "Business Intelligence",
    "Distributed Systems", "Parallel Computing", "Concurrency", "Algorithm Design", "Data Structures",
    "Computational Theory", "Digital Signal Processing", "Robotics", "3D Printing",
    "Augmented Reality", "Virtual Reality", "Mixed Reality", "User Research", "Heuristic Evaluation",
    "A/B Testing", "Prototyping", "Wireframing", "Accessibility", "Internationalization",
    "Localization", "Ethical Hacking", "Penetration Testing", "Incident Response", "Threat Intelligence",
    "Risk Management", "Compliance", "ISO", "GDPR", "CCPA", "Data Protection", "Forensics",
    "Malware Analysis", "Vulnerability Assessment", "Cloud Security", "Network Security",
    "Application Security", "Information Assurance", "Cryptography", "Blockchain Security",
    "Identity and Access Management", "SIEM", "SOC Operations", "Threat Hunting", "Digital Forensics",
    "Incident Handling", "Data Privacy", "Privacy Law", "Privacy Design", "Privacy Engineering",
    "GDPR Compliance", "CCPA Compliance", "Data Ethics", "AI Ethics", "Tech Policy",
    "Public Policy", "Regulatory Compliance", "Legal Compliance", "Ethics in Technology"
    };

    public static List<courses> initializeAvailableCourses(String allCoursesPath, String takenCoursesPath) throws IOException {
        Map<String, courses> allCourses = readAllCourses(allCoursesPath);
        markTakenCourses(allCourses, takenCoursesPath);

        // Filter and collect non-taken courses
        return allCourses.values().stream()
                .filter(course -> !course.isTaken())
                .collect(Collectors.toList());
    }

    private static Map<String, courses> readAllCourses(String filePath) throws IOException {
        Map<String, courses> coursesMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                courses course = parseCourse(line);
                coursesMap.put(course.getCourseId(), course);
            }
        }
        return coursesMap;
    }











    private static void markTakenCourses(Map<String, courses> courses, String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String courseId = line.trim();
                if (courses.containsKey(courseId)) {
                    courses.get(courseId).setTaken(true);
                }
            }
        }
    }







    

    private static courses parseCourse(String csvLine) {
        String[] values = csvLine.split(",");
        List<String> subjects = Arrays.asList(values[1].split(";"));
        return new courses(values[0], values[1], values[2], Double.parseDouble(values[3]));
    }








    public static List<String> getRecommendedCoursesForJobs(String filePath, List<String> desiredJobs) throws IOException {
        Map<String, List<String>> jobToCoursesMap = new HashMap<>();
        List<String> validRoles = Arrays.asList(COMPUTER_SCIENCE_KEYWORDS);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2 && validRoles.contains(values[0].trim()) && desiredJobs.contains(values[0].trim())) {
                    jobToCoursesMap.computeIfAbsent(values[0].trim(), k -> new ArrayList<>()).add(values[1].trim());
                }
            }
        }

        return jobToCoursesMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .distinct()
                .collect(Collectors.toList());
    }










    
    public static String[][] readCSVToArray(String filePath) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.split(","));
            }
        }
        return lines.toArray(new String[0][]);
    }
}
