//converts csv to 2d array
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

//fields variables and array implementation
var frontEnd = document.getElementById('frontDev').value;
var backEnd = document.getElementById('frontDev').value;
var backEnd = document.getElementById('frontDev').value;
var backEnd = document.getElementById('frontDev').value;
var fullStack = document.getElementById('frontDev').value;
var mobileDev = document.getElementById('frontDev').value;
var gameDev = document.getElementById('frontDev').value;
var dataSci = document.getElementById('frontDev').value;
var cyberSecurity = document.getElementById('frontDev').value;
var netManage = document.getElementById('frontDev').value;
var qAssure = document.getElementById('frontDev').value;
var cloud = document.getElementById('frontDev').value;
var consult = document.getElementById('frontDev').value;
var dataAdmin = document.getElementById('frontDev').value;
var imbedSys = document.getElementById('frontDev').value;
var research = document.getElementById('frontDev').value;
var ux = document.getElementById('frontDev').value;
const fields = [frontEnd,backEnd,fullStack,mobileDev,gameDev,dataSci,cyberSecurity,netManage,qAssure,cloud,consult,dataAdmin,imbedSys,research,ux]
for (let i=0;i<fields.length-1;i++){
    if(fields[i]!=null){
        fields[i] = true;
    }
    else{
        fields[i] = false;
    }
}

//comparing arrays to get courses list
var arr = [];
for(let i=1;i<courses.length-1;i++){
    var counter = 0;
    for(let j=1;j<16;i++){
        if(courses[i][j]==fields[j-1]){
            counter++;
        }
    }
    if(counter>=6){
        arr.add(courses[i]);
    }
}