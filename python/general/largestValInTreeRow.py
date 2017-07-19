#You need to find the largest value in each row of a binary tree.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


'''
My solution uses an auxilary list called 'next'. First attempt used
just a single list (a single queue). Try to figure out how to solve without auxiliary list.
This attempt needs aux list to help keep track of the levels of the values.
Inner for loop uses the length of the aux list. Or else for loop would iterate over
list that would change lengths because of the appending of children.
'''

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        
        levelVals = [[root.val]]
        index = 1
        
        q = []
        q.append(root)
        
        while(q):
            
            next = []
            for j in range(len(q)):
            
                top = q[j]
                
                if top.left:
                    next.append(top.left)
                    if index == len(levelVals):
                        levelVals.append([top.left.val])
                    else:
                        levelVals[index].append(top.left.val)

                if top.right:
                    next.append(top.right)
                    if index == len(levelVals):
                        levelVals.append([top.right.val])
                    else:
                        levelVals[index].append(top.right.val)
            q = next
            index += 1
        
        result = [];
        print(levelVals)
        for i in range(len(levelVals)):
            result.append(max(levelVals[i]))
            
        return result

    
#     class Solution(object):
#     def largestValues(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """
#         if root is None:
#             return []
        
#         levelVals = [[root.val]]
#         index = 1
#         counter = 0
        
#         q = []
#         q.append(root)
        
#         while(q):
            
#             top = q.pop(0)
#             if top.left:
#                 q.append(top.left)
#                 if index == len(levelVals):
#                     levelVals.append([top.left.val])
#                 else:
#                     levelVals[index].append(top.left.val)
                    
#             if top.right:
#                 q.append(top.right)
#                 if index == len(levelVals):
#                     levelVals.append([top.right.val])
#                 else:
#                     levelVals[index].append(top.right.val)
                    
#             counter += 2
#             if counter == 2**index:
#                 counter = 0
#                 index += 1
        
#         result = [];
#         print(levelVals)
#         for i in range(len(levelVals)):
#             result.append(max(levelVals[i]))
            
#         return result