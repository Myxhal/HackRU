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

var frontEnd;
var backEnd;
var fullStack;
var mobileDev;
var gameDev;
var dataSci;
var cyberSecurity;
var netManage;
var qAssure;
var cloud;
var consult;
var dataAdmin;
var imbedSys;
var research;
var ux;
const fields = [frontEnd,backEnd,fullStack,mobileDev,gameDev,dataSci,cyberSecurity,netManage,qAssure,cloud,consult,dataAdmin,imbedSys,research,ux]