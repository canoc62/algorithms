const arr = [1,2,3,4,5,6,7]

function BST(val) {
  this.val = val;
  this.left = null;
  this.right = null;
}

function printInOrder(tree) {
  
  if (tree) {
    printInOrder(tree.left);
    console.log(tree.val);
    printInOrder(tree.right);
  }
}

function minTree(arr, start, end) {
  if(start === undefined) {
    start = 0;
  }
  if(end === undefined) {
    end = arr.length - 1;
  }
  
  if(end < start) return null;
    
  const mid = Math.floor((start + end)/2);
  const node = new BST(arr[mid]);
  
  node.left = minTree(arr, start, mid - 1);
  node.right = minTree(arr, mid + 1, end);
  
  return node;
}

printInOrder(minTree(arr));