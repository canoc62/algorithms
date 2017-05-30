/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

function sum(array) {
    let sum = 0;
    
    for (let i = 0; i < array.length; i += 1) {
        sum += array[i];
    }
    return sum;
}

var combinationSum = function(candidates, target) {
    
    const solutions = [];
    
    function addSum(numbers, currSum) {
        // if (currSum === target) {
        //     solutions.push([])
        // }
        for (let i = 0; i < numbers.length; i += 1) {
            
            while (true) {
                if (currSum += numbers[i] < ) {
                    
                }
            }
        }
    }
};