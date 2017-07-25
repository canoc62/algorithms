def invertBST(self, node):

  if node is None:
      return

  temp = self.right
  self.right = self.left
  self.left = temp

  invert(node.left)
  invert(node.right)

  return node