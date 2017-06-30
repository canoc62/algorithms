
def tripleStep(stepsLeft):

  if stepsLeft == 0:
    return 1
  if stepsLeft < 0:
    return 0

  return tripleStep(stepsLeft - 1) + tripleStep(stepsLeft - 2) + tripleStep(stepsLeft - 3)

print(tripleStep(3))

