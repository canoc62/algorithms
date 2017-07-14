from random import randint
import os

def getUserPoint(userName):

  content = []
  try:
    scores = open('userScores.txt', 'r')

    for l in scores:
      splitLine = l.split(', ')
      splitLine[1] = splitLine[1][:len(splitLine[1]) - 1]
      print(splitLine)
      content.append(splitLine)
      if splitLine[0] == userName:
        scores.close()
        return splitLine[1]
    
    scores.close()
    return '-1'
  except IOError as e:
    print(e)
    print("Creating file...")
    scores = open('userScores.txt', 'w')
    scores.close()
    return '-1'

def updateUserPoints(newUser, userName, score):

  try:
    if newUser == True:
      scores = open('userScores.txt', 'a')
      scores.write("\n" + userName + ", " + str(score))
      scores.close()
    else:
      scores = open('userScores.txt', 'r')
      temp = open('tempScores.txt', 'w')
      for l in scores:
        #print(l[:l.find(',')])
        if l[:l.find(',')] == userName:
          temp.write(userName + ", " + str(score))
        else:
          temp.write(l)
      scores.close()
      os.remove('userScores.txt')
      temp.close()
      os.rename('tempScores.txt', 'userScores.txt')
  except IOError as e:
    print(e)
    print("Creating file...")
    scores = open('userScores.txt', 'w')
    scores.write(userName + ", " + score)
    scores.close()
  
  return '-1'
    

#if __name__ == '__main__':

operandList = [0, 0, 0, 0, 0]
operatorList = ['', '', '', '']

operatorDict = { 1: "+", 2: "-", 3: "*", 4: "**"}

def generateQuestion():

  for i in range(len(operandList)):
    operandList[i] = randint(1, 9)

  for i in range(len(operatorList)):
    operator = operatorDict[randint(1,4)]
    if i > 0 and operatorList[i - 1] == "**":
      while(operator == "**"):
        operator = operatorDict[randint(1,4)]

    operatorList[i] = operator

  questionString = ''
  operatorListLength = len(operatorList)

  for i in range(len(operandList)):
    if (i > operatorListLength - 1):
      questionString += str(operandList[i])
    else:
      questionString += str(operandList[i]) + operatorDict[i + 1]
  
  result = eval(questionString)

  questionString = questionString.replace('**', '^')
  print("What is the result of " + questionString + "?")
  answer = input()

  while(True):
    try:
      answer = int(answer)
      break
    except:
      print("You did not enter a number! Try again: ")
      answer = input()

  if answer == result:
    print("You got the answer correct: " + str(result))
    return result
  else:
    print("You did not get the answer correct, it was: " +  str(result))
    return -result
