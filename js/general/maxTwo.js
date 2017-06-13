function largestTwo(arr) {
  
  if (arr.length < 2) throw Error("Array length does not have enough values.");
  
  let largest = arr[0] > arr[1] ? arr[0] : arr[1];
  let secondLargest = arr[0] < arr[1] ? arr[0] : arr[1];
  
  // if (arr.length > 2) {
  //   for (let i = 2; i < arr.length; i += 1) {
  //     if (arr[i] > largest) {
  //       secondLargest = largest;
  //       largest = arr[i];
  //     } else if (arr[i] > secondLargest && arr[i] !== largest) {
  //       secondLargest = arr[i];
  //     }
  //   }
  // }
  let result;
  
  if (arr.length > 2) {
    for (let i = 2; i < arr.length; i += 1) {
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] > secondLargest) {// && arr[i] !== largest) {
        secondLargest = arr[i];
      }
    }
  }
  
  return { largest, secondLargest };
}

largestTwo([-1, 4, 6, 34, -4, 2, 34]);