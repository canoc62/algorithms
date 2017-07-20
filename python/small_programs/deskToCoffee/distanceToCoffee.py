from nodes import Node

def distanceToCoffee(rows, cols, deskLocation, coffeeLocations, walls):
  print("Desk located at: {}, {}\n".format(deskLocation[0], deskLocation[1]))

  nodes = createNodes(rows, cols)
  addCoffeesAndWalls(nodes, coffeeLocations, walls)
  addNeighbors(nodes, rows, cols)
  printGrid(nodes, rows, cols)

  return search(nodes, deskLocation)


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


def addCoffeesAndWalls(nodes, coffeeLocations, walls):
  for loc in range(len(coffeeLocations)):
    coffeeKey = str(coffeeLocations[loc][0]) + str(coffeeLocations[loc][1])
    nodes[coffeeKey].symbol = 'c'

  for wall in range(len(walls)):
    wallKey = str(walls[wall][0]) + str(walls[wall][1])
    nodes[wallKey].symbol = 'x'


def addNeighbors(nodes, rows, cols):
  for key, value in nodes.items():
    createNeighbors(value, nodes, rows, cols)


def createNeighbors(node, nodeList, rows, cols):
  directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

  for i in range(len(directions)):
    neighborX = node.x + directions[i][0]
    neighborY = node.y + directions[i][1]

    if (neighborX < 1 or neighborX >= rows + 1 or neighborY < 1 or neighborY >= cols + 1):
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
