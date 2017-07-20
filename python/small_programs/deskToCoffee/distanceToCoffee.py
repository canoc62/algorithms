from nodes import Node

def distanceToCoffee(rows, cols, deskLocation, coffeeLocations, walls):
  checkTypeArgs(rows, cols, deskLocation, coffeeLocations, walls)

  validateCoordinate(deskLocation, rows, cols)
  print("Desk located at: {}, {}\n".format(deskLocation[0], deskLocation[1]))

  grid = constructGrid(rows, cols, coffeeLocations, walls)

  return search(grid, deskLocation)


def checkTypeArgs(rows, cols, deskLocation, coffeeLocations, walls):
  if isinstance(rows, int) == False:
    raise TypeError("rows argument must be an instance of \'int\'")
  if isinstance(cols, int) == False:
    raise TypeError("cols argument must be an instance of \'int\'")
  if isinstance(deskLocation, list) == False:
    raise TypeError("deskLocation argument must be an instance of \'list\'")
  if isinstance(coffeeLocations, list) == False:
    raise TypeError("coffeeLocations argument must be an instance of \'list\'")
  if isinstance(walls, list) == False:
    raise TypeError("walls argument must be an instance of \'list\'")


def validateCoordinate(coordinate, rows, cols):
  if isinstance(coordinate, list) == False:
      raise TypeError("Coordinate container must"
                      " be an instance of \'list\'")

  checkForInt(coordinate[0])
  checkForInt(coordinate[1])
  checkForInBoundaryValue(coordinate[0], coordinate[1], rows, cols)


def checkForInt(value):
  if isinstance(value, int) == False:
    raise TypeError("value must be an instance of \'int\'")


def checkForInBoundaryValue(value1, value2, rows, cols):
  if value1 < 1 or value1 > rows or \
       value2 < 1 or value2 > cols:
      raise AssertionError("Coordinate values must lie between"
                           " the rows and columns values provided")


def constructGrid(rows, cols, coffeeLocations, walls):
  nodes = createNodes(rows, cols)
  addCoffeesAndWalls(nodes, coffeeLocations, walls, rows, cols)
  addNeighbors(nodes, rows, cols)
  printGrid(nodes, rows, cols)

  return nodes
  

def printGrid(nodes, rows, cols):
  for i in range(1, rows + 1):
    for j in range(1, cols + 1):
      key = str(i) + str(j)
      print(nodes[key].symbol, end='')
    print('')


def createNodes(rows, cols):
  nodes = {}

  for i in range(1, rows + 1):
    for j in range(1, cols + 1):
      key = str(i) + str(j)
      nodes[key] = Node(i, j)
  
  return nodes


def addCoffeesAndWalls(nodes, coffeeLocations, walls, rows, cols):
  for location in range(len(coffeeLocations)):
    coffeeCoordinate = coffeeLocations[location]
    validateCoordinate(coffeeCoordinate, rows, cols)
    
    coffeeKey = str(coffeeCoordinate[0]) + str(coffeeCoordinate[1])
    nodes[coffeeKey].symbol = 'c'

  for location in range(len(walls)):
    wallCoordinate = walls[location]
    validateCoordinate(wallCoordinate, rows, cols)

    wallKey = str(wallCoordinate[0]) + str(wallCoordinate[1])
    nodes[wallKey].symbol = 'x'


def addNeighbors(nodes, rows, cols):
  for key, value in nodes.items():
    createNeighbors(value, nodes, rows, cols)


def createNeighbors(node, nodeList, rows, cols):
  directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

  for i in range(len(directions)):
    neighborX = node.x + directions[i][0]
    neighborY = node.y + directions[i][1]

    if (neighborX < 1 or neighborX >= rows + 1 \
        or neighborY < 1 or neighborY >= cols + 1):
      continue

    keyOfNeighbor = str(neighborX) + str(neighborY)
    potentialNeighbor = nodeList[keyOfNeighbor]

    if (potentialNeighbor.symbol == 'x'):
      continue
    node.neighbors.append(potentialNeighbor)


def search(nodes, deskLocation):
  levels = {}
  deskLocationKey = str(deskLocation[0]) + str(deskLocation[1])
  queue = [nodes[deskLocationKey]]
  level = 0

  while queue:
    next = []

    for node in range(len(queue)):
      neighbors = queue[node].neighbors
      for neighbor in range(len(neighbors)):
        currentNeighbor = neighbors[neighbor]
        if currentNeighbor.symbol == 'c':
          return level + 1
        if currentNeighbor.key not in levels:
          levels[currentNeighbor.key] = level
          next.append(currentNeighbor)
    queue = next
    level += 1

  return -1
