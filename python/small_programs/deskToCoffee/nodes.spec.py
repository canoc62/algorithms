from nodes import Node

def testNode():
  coordinates = [1,1]
  key = '11'
  symbol = '-'
  newNode = Node(coordinates[0], coordinates[1])
  newNodeX = newNode.x 
  newNodeY = newNode.y
  print('coordinates: {}\n'.format(coordinates))
  # Coordinates Test
  print("Coordinates Test")
  if newNodeX == coordinates[0] and newNodeY == coordinates[1]:
    print("PASS: Coordinates for node have"
          " been set correctly at {}, {}\n".format(newNodeX, newNodeY))
  else:
    print("FAIL: Expected"
          " coordinates -> {}, {}".format(coordinates[0], coordinates[1]))
    print("Actual coordinates: {}, {}\n".format(newNodeX, newNodeY))

  # Key Test
  print("Key Test")
  if newNode.key == key:
    print("PASS: node key has been set correctly at {}\n").format(newNode.key)
  else:
    print("FAIL: Expected"
          " key -> {}".format(key))
    print("Actual key: {}\n".format(newNode.key))

  # Symbol Test
  print("Symbol Test")
  print("Default Symbol Test")
  if newNode.symbol == symbol:
    print("PASS: node symbol has been set correctly to default {}\n").format(newNode.symbol)
  else:
    print("FAIL: Expected"
          " symbol -> {}".format(symbol))
    print("Actual symbol: {}\n".format(newNode.symbol))
  
  newSymbol = 'x'
  newNode.symbol = 'x'
  print("Changed Symbol Test")
  if newNode.symbol == newSymbol:
    print("PASS: node symbol has been changed correctly to {}\n").format(newNode.symbol)
  else:
    print("FAIL: Expected"
          " new symbol -> {}".format(newSymbol))
    print("Actual symbol: {}\n".format(newNode.symbol))

  # Neighbors Test
  print("Neighbors Test")
  if isinstance(newNode.neighbors, list):
    print("PASS: newNode neighbors attribute is of type list")
  else:
    print("FAIL: newNode neighbors attribute is not of type list")


testNode()