



const fs = require('fs');
const searchInput = document.querySelector("[data-search]")

searchInput.addEventListener("input", e =>{
    const value = e.target.value
    console.log(value)
})

//converts csv to 2d array
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
var backEnd = document.getElementById('backDev').value;
var fullStack = document.getElementById('fullStack').value;
var mobileDev = document.getElementById('mobDev').value;
var gameDev = document.getElementById('gameDev').value;
var dataSci = document.getElementById('dataSci').value;
var cyberSecurity = document.getElementById('cyberSec').value;
var netManage = document.getElementById('netManag').value;
var qAssure = document.getElementById('qualAssure').value;
var cloud = document.getElementById('cloud').value;
var consult = document.getElementById('consult').value;
var dataAdmin = document.getElementById('dataAdmin').value;
var imbedSys = document.getElementById('imbedSys').value;
var research = document.getElementById('research').value;
var ux = document.getElementById('ux').value;
const fields = [frontEnd,backEnd,fullStack,mobileDev,gameDev,dataSci,cyberSecurity,netManage,qAssure,cloud,consult,dataAdmin,imbedSys,research,ux]
for (let i=0;i<fields.length-1;i++){
    if(fields[i]!=null){
        fields[i] = true;
    }
    else{
        fields[i] = false;
    }
}


removeTakenCourses(courses, takenCourses);

let takenCourses = ["selectedCoursesTakenFromWebsite"];

function removeTakenCourses(courses, takenCourses) {

    courses.splice(0, 1); // This removes the first element of the courses array

    // Loop through the courses array from the end to the beginning
    for (let i = courses.length - 1; i > 0; i--) {
        // Check if the current course's identifier matches any in the takenCourses array
        if (takenCourses.includes(courses[i][1])) {
            // Remove the course from the courses array if there's a match
            courses.splice(i, 1);
        }
    }
}



//comparing arrays to get courses list
var arr = [];
for(let i=0;i<courses.length-1;i++){
    var counter = 0;
    for(let j=1;j<16;j++){
        if(courses[i][j]==fields[j-1]){
            counter++;
        }
    }
    if(counter>=6){
        arr.push(courses[i]);
    }
}

//add dem to html file
course1.value = arr[0]+", "+arr[18]+", "+arr[20];
course1.value = arr[19];
