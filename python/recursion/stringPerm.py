
# def computePerm(string, index, currStr = '', permsList = []):

#   if (len(currStr) == len(string)):
#     permsList.append(currStr)
#     return permsList

#   for index in range(len(string)):
#     if string[index] not in currStr:
#       # # if index == 0: 
#       # #   print(" whut: " + currStr+ ", " + string[index])
#       # if currStr == 'y' and index == 0:
#       #   print('hello')
#       permsList + computePerm(string, index + 1, currStr + string[index], permsList)

#   return permsList

# print(computePerm('xyz', 0, '', []))

def computePerm(string, currStr = '', permsList = []):

  if (len(currStr) == len(string)):
    #permsList.append(currStr)
    return permsList + [currStr]

  for index in range(len(string)):
    if string[index] not in currStr:
      permsList = computePerm(string, currStr + string[index], permsList)

  return permsList

print(computePerm('xyz', '', []))
  