
// # def computePerm(string, index, currStr = '', permsList = []):

// #   if (len(currStr) == len(string)):
// #     permsList.append(currStr)
// #     return permsList

// #   for index in range(len(string)):
// #     if string[index] not in currStr:
// #       # # if index == 0: 
// #       # #   print(" whut: " + currStr+ ", " + string[index])
// #       # if currStr == 'y' and index == 0:
// #       #   print('hello')
// #       permsList + computePerm(string, index + 1, currStr + string[index], permsList)

// #   return permsList

// # print(computePerm('xyz', 0, '', []))

function computePerm(string, currStr = '', permsList = []) {
//console.log('asdfasdfasdf');
  if (currStr.length === string.length) {
    //permsList.push(currStr);
    return permsList.concat(currStr);
  }

  for (let index = 0; index < string.length; index++) {
    //console.log('asdfasdf');
    if (!currStr.includes(string[index])) {
      //permsList = permsList.concat(computePerm(string, currStr + string[index], permsList));
      permsList = computePerm(string, currStr + string[index], permsList)
    }
  }

  return permsList;
}

console.log(computePerm('xyz', '', []));