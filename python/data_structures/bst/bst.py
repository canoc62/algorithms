class BSTNode:
    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None


class BST:
    def __init__(self, root):
        self.root = root

    def add_node(self, new_val):
        curr = self.root

        while True:
            if new_val == curr.value:
                print("Value already of node already exists")
                break
            if new_val > curr.value:
                if curr.right is not None:
                    curr = curr.right
                else:
                    curr.right = BSTNode(new_val)
                    break
            elif new_val < curr.value:
                if curr.left is not None:
                    curr = curr.left
                else:
                    curr.left = BSTNode(new_val)
                    break

        return curr

    def print_in_order(self, node):

        if node is not None:
            self.print_in_order(node.left)
            print(node.value)
            self.print_in_order(node.right)

    def print_post_order(self, node):

        if node is not None:
            self.print_in_order(node.left)
            self.print_in_order(node.right)
            print(node.value)

    def print_pre_order(self, node):

        if node is not None:
            print(node.value)
            self.print_in_order(node.left)
            self.print_in_order(node.right)

    def get_height(self, node):

        if node is None:
            return 0

        return 1 + max(self.get_height(node.left), self.get_height(node.right))

    def is_super_balanced(self, node):

        if node is None:
            return True

        left_height = self.get_height(node.left)
        right_height = self.get_height(node.right)

        return abs(left_height - right_height) <= 1 and self.is_super_balanced(node.left) and self.is_super_balanced(
            node.right)