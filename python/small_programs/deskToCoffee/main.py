from distanceToCoffee import distanceToCoffee

coffees1 = [[1, 3], [3, 2]]
walls1 = [[2, 2], [2, 3], [3, 1]]
print(distanceToCoffee(3, 4, [2,1], coffees1, walls1))

coffees2 = [[1, 1]]
walls2 = [[2, 1], [2, 2], [2, 3], [2, 4], [3, 1], [3, 2], [3, 3], [3, 4]]
print(distanceToCoffee(4, 5, [4,1], coffees2, walls2))