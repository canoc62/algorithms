from distanceToCoffee import distanceToCoffee

print("distanceToCoffee Test\n")
print("it should output the correct distance\n")

print("Test 1")
print("Input: 3x4 grid\n"
      "coffee coordinates: (1,3) (3,2)\n"
      "wall coordinates: (2,2) (2,3) (3,1)\n"
      "desk coordinates: (2,1)")

rows1 = 3
cols1 = 4
coffees1 = [[1, 3], [3, 2]]
walls1 = [[2, 2], [2, 3], [3, 1]]
desk1 = [2,1]
expectedDistance1 = 3
actualDistance1 = distanceToCoffee(rows1, cols1, desk1, coffees1, walls1)

if expectedDistance1 == actualDistance1:
  print("PASS: correct distance {}\n".format(actualDistance1))
else:
  print("FAIL:\n")
  print("Expected distance: {}".format(expectedDistance1))
  print("Actual distance: {}\n".format(actualDistance1))

print("Test 2")
print("Input: 3x4 grid\n"
      "coffee coordinates: (1,1)\n"
      "wall coordinates: (2,1) (2,2) (2,3) (2,4) (3,1) (3,2) (3,3) (3,4)\n"
      "desk coordinates: (4, 1)")
rows2 = 4
cols2 = 5
coffees2 = [[1, 1]]
walls2 = [[2, 1], [2, 2], [2, 3], [2, 4], [3, 1], [3, 2], [3, 3], [3, 4]]
desk2 = [4, 1]
expectedDistance2 = 11
actualDistance2 = distanceToCoffee(rows2, cols2, desk2, coffees2, walls2)
if expectedDistance2 == actualDistance2:
  print("PASS: correct distance {}\n".format(actualDistance2))
else:
  print("FAIL:\n")
  print("Expected distance: {}".format(expectedDistance2))
  print("Actual distance: {}\n".format(actualDistance2))
