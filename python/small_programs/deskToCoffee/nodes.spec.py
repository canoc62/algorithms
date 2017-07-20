from nodes import Node

def testNode(coordinates):
  newNode = Node(coordinates[0], coordinates[1])
  newNodeX = newNode.x 
  newNodeY = newNode.y

  # Coordinates Test
  print("Coordinates Test")
  if newNodeX == coordinates[0] and newNodeY == coordinates[1]:
    print("PASS: Coordinates for node have been set correctly at {}, {}\n".format(newNodeX, newNodeY))
  else:
    print("FAIL: Expected coordinates -> {}, {}".format(coordinates[0], coordinates[1]))
    print("Actual coordinates: {}, {}\n".format(newNodeX, newNodeY))

testNode([1,1])