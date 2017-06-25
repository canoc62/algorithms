/* 
Cash Register Test:
The units of currency in this country are a bit strange. 
We need a function for a cash register, makeChange.
It should tell the cashier how many units to give in change, 
largest to smallest, based on the cost of all their items in 
the cart and the amount given by the customer.

Edit makeChange to work with any cost, amount or units.
*/

var units = {
  'dollar': 100,
  'half dollar': 50,
  'trey': 30,
  'niner': 9,
  'cent': 1
};

function updateChangeToGive(changeToGive, changeLeft, unitAmount, unit) {
  changeToGive += Math.floor(changeLeft / unitAmount) + " " + unit + "\n";
  return changeToGive;
}

function updateChangeLeft(changeLeft, unitAmount) {
  changeLeft %= unitAmount;
  return changeLeft;
}
 
function makeChange(totalCost, amountGiven, units) {
  
  const changeAmount = amountGiven - totalCost;
  
  let changeLeft = changeAmount;
  
  let changeToGive = '';
  
  while (changeLeft > 0) {
    if (Math.floor(changeLeft / units['dollar']) >= 1) {
      
      changeToGive =updateChangeToGive(changeToGive, changeLeft, units['dollar'], 'dollar');
      
      changeLeft = updateChangeLeft(changeLeft, units['dollar']);
    } else if (Math.floor(changeLeft / units['half dollar']) >= 1) {
      
      changeToGive = updateChangeToGive(changeToGive, changeLeft, units['half dollar'], 'half dollar');
      
      changeLeft = updateChangeLeft(changeLeft, units['half dollar']);
    } else if (Math.floor(changeLeft / units['trey']) >= 1) {
      
      changeToGive = updateChangeToGive(changeToGive, changeLeft, units['trey'], 'trey');
      
      changeLeft = updateChangeLeft(changeLeft, units['trey']);
    } else if (Math.floor(changeLeft / units['niner']) >= 1) {
      
      changeToGive = updateChangeToGive(changeToGive, changeLeft, units['niner'], 'niner');
      
      changeLeft = updateChangeLeft(changeLeft, units['niner']);
    } else if (Math.floor(changeLeft / units['cent']) >= 1) {
      
      changeToGive = updateChangeToGive(changeToGive, changeLeft, units['cent'], 'cent');
      
      changeLeft = updateChangeLeft(changeLeft, units['cent']);
    } else {
      break; 
    }
  }
  return changeToGive;
}
console.log(makeChange(21, 100, units));
if (makeChange(21, 100, units) === "1 half dollar\n3 niner\n2 cent\n") {
  console.log("test passed");
} else {
  console.log("test failed");
}

// console.log(makeChange(1, 50, units));
// if (makeChange(1, 50, units) === "1 trey\n2 niner\n1 cent\n") {
//   console.log("test passed");
// } else {
//   console.log("test failed");
// }
