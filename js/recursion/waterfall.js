function waterfall(funcArr, final, result) {
  
  if (!funcArr.length) {
    return final(null, result);
  }
  
  const nextFunc = funcArr[0];
  
  nextFunc((err, data) => {
    if (err) return final(err);
    
    waterfall(funcArr.slice(1), final, data);
  })
}

function total(err, result=0) {
  if (err) {
    console.log('error: ', err);
  }
  console.log('RESULT: ', result);
  return result;
}

let sum = 0;

waterfall([
  function(callback) {
    sum += 1;
    callback(null, sum);
  },
  function(callback) {
    sum += 1;
    callback(null, sum);
  },
  function(callback) {
    sum += 1;
    callback(null, sum);
  }
], total);
