const fs = require('fs');
const readline = require('readline');

async function readCSVToArray(filePath) {
    const fileStream = fs.createReadStream(filePath);
    var lines = [];
    
    const rl = readline.createInterface({
        input: fileStream,
        crlfDelay: Infinity
    });

    for await (const line of rl) {
        lines.push(line.split(','));
    }
    
    return lines;
}

readCSVToArray('courses.csv');