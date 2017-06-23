const fs = require('fs');

function traverse(json_file) {

  //const parsed = JSON.parse(json_file);
  const file_structure = fs.readFileSync(json_file);
  const parsed = JSON.parse(file_structure.toString());
  console.log("parsed: ", parsed);

  function log(currPath) {
    if (/*currPath["type"] === "folder" && */currPath.hasOwnProperty("children")) {
      let directoryChildren = currPath["children"];
      for (let i = 0; i < directoryChildren.length; i += 1) {
        //console.log()
        if (directoryChildren[i]["type"] === "folder") {
          log(directoryChildren[i]);
        } else if (directoryChildren[i]["type"] === "file") {
          console.log(directoryChildren[i]["name"]);
        }
      }
    }
  }

  log(parsed);
}

traverse(process.argv[2]);