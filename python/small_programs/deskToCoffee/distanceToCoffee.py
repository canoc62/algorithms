from nodes import Node

# def distanceToCoffee(rows, cols, deskLocation, coffeeLocations, walls):
#   nodes = []

#   for i in range(rows):
#     for j in range(cols):
#       nodes.append(Node(i, j))
  

# def createNeighbors(node, nodeList, rows, cols):

#   directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

#   for i in range(len(directions)):
#     neighborX = node.x + directions[i][0]
#     neighborY = node.y + directions[i][1]

#     if (neighborX < 0 or neighborX >= rows or neighborY < 0 or neighborY >= cols):
#       continue

#     indexOfNeighbor = neighborX * rows + neighborY
#     potentialNeighbor = nodeList[indexOfNeighbor]

#     if (potentialNeighbor.symbol == 'x'):
#       continue
#     node.neighbors.append(potentialNeighbor)


def distanceToCoffee(rows, cols, deskLocation, coffeeLocations, walls):

  print("desk located at {}, {}".format(deskLocation[0], deskLocation[1]))

  nodes = {}

  for i in range(rows):
    for j in range(cols):
      key = str(i) + str(j)
      nodes[key] = Node(i, j)
  
  for loc in range(len(coffeeLocations)):
    coffeeKey = str(coffeeLocations[loc][0]) + str(coffeeLocations[loc][1])
    nodes[coffeeKey].symbol = 'c'

  for wall in range(len(walls)):
    wallKey = str(walls[wall][0]) + str(walls[wall][1])
    nodes[wallKey].symbol = 'x'

  for i in range(rows):
    for j in range(cols):
      key = str(i) + str(j)
      print(nodes[key].symbol, end='')
    print('')

  for key, value in nodes.items():
    createNeighbors(value, nodes, rows, cols)

  return search(nodes, deskLocation)

def createNeighbors(node, nodeList, rows, cols):

  directions = [[0, 1], [-1, 0], [0, -1], [1, 0]]

  for i in range(len(directions)):
    neighborX = node.x + directions[i][0]
    neighborY = node.y + directions[i][1]

    if (neighborX < 0 or neighborX >= rows or neighborY < 0 or neighborY >= cols):
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

coffees = [[0, 2], [2, 1]]
walls = [[1, 1], [1, 2], [2, 0]]

print(distanceToCoffee(3, 4, [2,3], coffees, walls))