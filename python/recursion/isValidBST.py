# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        if root is None:
            return True
        
        if (root.left is not None):
            print(root.left)
            if (root.val <= root.left.val or isinstance(root.left, TreeNode) == False):
                return False
        
        if (root.right is not None):
            print(root.left)
            if (root.val >= root.right.val or isinstance(root.right, TreeNode) == False):
                return False
        
        return True and self.isValidBST(root.left) and self.isValidBST(root.right)