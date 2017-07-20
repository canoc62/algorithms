class Node:

  def __init__(self, x, y, symbol = '-'):
    self.x = x
    self.y = y
    self.key = str(x) + str(y)
    self.symbol = symbol
    self.neighbors = []
