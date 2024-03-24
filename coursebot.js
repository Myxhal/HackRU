const fs = require('fs');

function csvTo2DArray(filePath) {
    try {
        // Read the file content
        const content = fs.readFileSync(filePath, { encoding: 'utf-8' });
        
        // Split the content by new lines to get rows, then split each row by comma
        const rows = content.split('\n').map(row => row.split(','));
        
        return rows;
    } catch (error) {
        console.error("Error reading the file:", error);
        return [];
    }
}
var courses = csvTo2DArray('courses.csv');

const keywords = ["Software", "Web", "Mobile", "Database", "Systems", "Network", "Data", "Machine Learning",
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
"Distributed Systems", "Parallel Computing", "Concurrency", "Algorithm Design", "Data Structures"
, "Digital Signal Processing", "Robotics", "3D Printing",
"Augmented Reality", "Virtual Reality", "Mixed Reality", "User Research", "Heuristic Evaluation"
, "Prototyping", "Wireframing", "Accessibility", "Internationalization",
"Localization", "Ethical Hacking", "Penetration Testing", "Incident Response", "Threat Intellige"
, "Compliance", "ISO", "GDPR", "CCPA", "Data Protection", "Forensics",
"Malware Analysis", "Vulnerability Assessment", "Cloud Security", "Network Security",
"Application Security", "Information Assurance", "Cryptography", "Blockchain Security",
"Identity and Access Management", "SIEM", "SOC Operations", "Threat Hunting", "Digital Forensics"
, "Data Privacy", "Privacy Law", "Privacy Design", "Privacy Engineering",
"GDPR Compliance", "CCPA Compliance", "Data Ethics", "AI Ethics", "Tech Policy",
"Public Policy", "Regulatory Compliance", "Legal Compliance", "Ethics in Technology"];
