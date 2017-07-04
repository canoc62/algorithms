# Find the number of ways that a given integer, X, can be expressed as the sum of the Nth power of unique, natural numbers.

# Explanation 0

# If X = 10 and N = 2, we need to find the number of ways that 10 can be represented as the sum of squares of unique numbers.

# 10 = 1^2 + 3^2
# This is the only way in which 10 can be expressed as the sum of unique squares.

x = int(input())
n = int(input())

square = int(pow(x, 1 / n))
#print(int(pow(x, 1 / n)))

def powerSum(summ, total, power, limit, square):
    
    if limit > square or summ > total:
        return 0
    if summ == total:
        return 1
    
    newSumm = summ + limit**power
    return powerSum(newSumm, total, power, limit + 1, square) + powerSum(summ, total, power, limit + 1, square)

print(powerSum(0, x, n, 0, square))