

def coinSum(coinVals, sum, index):

  totalCoinValue = 0
  solutions = 0

  if sum == 0:
    return 1
  
  if index >= len(coinVals):
    return 0

  while totalCoinValue <= sum:
    remaining = sum - totalCoinValue
    solutions += coinSum(coinVals, remaining, index + 1)
    totalCoinValue += coinVals[index]
  
  return solutions

coins = [2,5]

print(coinSum(coins, 10, 0))