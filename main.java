import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {

        String allCoursesPath = "courses.csv";

        String takenCoursesPath = "courses.csv";

        List<courses> availableCourses = courseInitializer.initializeAvailableCourses(allCoursesPath, takenCoursesPath);

     }
}

const fs = require('fs');
const readline = require('readline');

async function readCSVToArray(filePath) {
    const fileStream = fs.createReadStream(filePath);
    const lines = [];
    
    const rl = readline.createInterface({
        input: fileStream,
        crlfDelay: Infinity
    });

    for await (const line of rl) {
        lines.push(line.split(','));
    }
    
    return lines;
}

// Example usage
const filePath = './path/to/your/file.csv';
readCSVToArray(filePath)
    .then(lines => {
        console.log(lines);
    })
    .catch(error => {
        console.error(error);
    });

