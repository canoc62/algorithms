const arr1 = [1, [2,3, 3, 3], [[[4, 3, 1]]]];

 function flattenAndNest(arr) {
  const cache = {};
   let flattened = [];
   
   function recurse(array) {
   	for (let i = 0 ; i < array.length; i +=1) {
     if (Array.isArray(array[i])) { 
      recurse(array[i]);
     } else {
       if (!cache.hasOwnProperty(array[i])) {
        cache[array[i]] = true;
         flattened.push(array[i]);
       }
     }
    }
   return flattened;
  }
   return recurse(arr);
 }
 
 flattenAndNest(arr1);