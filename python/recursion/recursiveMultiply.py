
def recursiveMultiply(x, y):

  if y == 0:
    return 0
  if y == 1:
    return x

  return x + recursiveMultiply(x, y - 1)

print(recursiveMultiply(5, 10))