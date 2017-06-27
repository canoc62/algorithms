// log-file.js
// traverse a file system (JSON format) and log only files, not directories
const fs = require('fs');

function logFile(json_file) {
  const file_structure = fs.readFileSync(json_file);
  const parsed = JSON.parse(file_structure.toString());

 function scan(directory, parent='') {
    for (let i in directory) {
      let currPath = parent + i;
      let currFile = fs.statSync(currPath);
      if (currFile.isDirectory()) {
        scan(directory[i], currPath);
      } else {
        console.log(directory[i]);
      }
    }
  }

 scan(parsed);
}

logFile(process.argv[2]);