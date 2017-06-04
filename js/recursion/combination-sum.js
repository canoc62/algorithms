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

function combinationSum(candidates, target) {
 
 const solutions = [];
 const copyCandidates = candidates.slice();
 
 function recurse(currCandidates, solutionSet = [], currSum = 0) {
   
   for (let i = 0; i < currCandidates.length; i += 1) {
     if (currSum + currCandidates[i] < target) {
       recurse(currCandidates.slice(i), solutionSet.concat(currCandidates[i]), currSum + currCandidates[i]);
     } else if (currSum + currCandidates[i] === target) {
       solutions.push(solutionSet.concat(currCandidates[i]));
     }
   }
 }
 
 recurse(copyCandidates);
 
 return solutions;
}