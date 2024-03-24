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

// Example usage
const filePath = 'courses.csv';
