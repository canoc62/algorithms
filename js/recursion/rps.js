/**
 * returns every sequence of throws a single player could throw over a three-round game of rock-paper-scissors
 * rockPaperScissors(1); -> [['rock'],['paper'],['scissors']]
 * rockPaperScissors(2); -> 
 * [['rock','rock'],['rock','paper'],['rock','scissors'],
 * ['paper','paper'],['paper','scissors'],['paper','rock'],
 * ['scissors','scissors'],['scissors','paper'],['scissors','rock']]
 */
function rockPaperScissors(num) {
  if (num < 1) return [];
  const result = [];

  function getHands(num, subArr = []) {
    if (num === 0) return result.push(subArr);

    getHands(num - 1, subArr.concat('rock'));
    getHands(num - 1, subArr.concat('paper'));
    getHands(num - 1, subArr.concat('scissors'));
  }

  getHands(num);
  return result;
}