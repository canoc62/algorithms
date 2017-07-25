def invertBST(node):

  if node is None:
    return

  temp = node.right
  node.right = node.left
  node.left = temp

  invert(node.left)
  invert(node.right)

  return node