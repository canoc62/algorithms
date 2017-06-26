/*
Description:
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Requirements:
Elements in a triplet (a,b,c) must be in ascending 
order (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
    For example, given an array [-1, 0, 1, 2, -1, -4]
    A solution set is [[-1, 0, 1], [-1, -1, 2]]
*/

var set1 = [-1, 0, 1, 2, -1, -4];
var set2 = [-3, 20, -5, -17, 3, 0, 8, -5, 10];

// Write a method that handles both set1 and set2 successfully
function findZeroSumTriplets(inputSet) {
  
  const solutions = [];
  const copyInput = inputSet.sort().slice();
  const solutionsObj = {};
  
  function recurse(currentCopy, solutionSet = [], currentSum = 0, currIndex = 0) {
    for (currIndex; currIndex < currentCopy.length; currIndex++) {
      if (currentSum + currentCopy[currIndex] !== 0) {
        recurse(currentCopy.slice(1), solutionSet.concat(currentCopy[currIndex]), currentSum + currentCopy[currIndex], currIndex);
      } else {
        solutionSet = solutionSet.concat(currentCopy[currIndex]);
        let key= solutionSet.join('');
        
        if (solutionSet.length === 3 && !solutionsObj.hasOwnProperty(key)) {
          solutionsObj[key] = true;
          solutions.push(solutionSet);
        } 
      }
    }
  }
  recurse(copyInput);
  return solutions;
}

// Write a valid test function that asserts all of the requirements
function assertTripletsAddToZero(inputArray) {
  
  let sum = 0;
  const testSolutionsObj = {};
  
  for (let i = 0; i < inputArray.length; i++) {
    let key = inputArray[i].join('');
    
    if (inputArray[i].length !== 3) return false;
    
    if (!testSolutionsObj.hasOwnProperty(key)) {
      testSolutionsObj[key] = true;
    } else {
      return false; 
    }
    
    for (let j = 0; j < inputArray[i].length; j++) {
      if (j > 0) {
        if (inputArray[i][j] < inputArray[i][j-1]) return false; 
      }
      sum += inputArray[i][j];
    }

    if (sum !== 0) return false;
    sum = 0;
  }
  return true;
}

if (assertTripletsAddToZero(findZeroSumTriplets(set1))) {
  console.log("test passed");
} else {
  console.log("test failed");
}

console.log(findZeroSumTriplets([-1, -4, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]));