# bugs -> always same equation
# add -> division, overflow case, parentheses case

from myPythonFunctions import *

try:

  print("Hi, what is your name?")
  username = input()

  userScore = int(getUserPoint(username))

  if userScore < 0:

    print('heelllooo')
    newUser = True
    updateUserPoints(newUser, username, 0)

  userChoice = 0
  newUser = False
  while(True):
    print("Enter anything other than \'-1\', entering \'-1\' will exit the program: ")
    userChoice = input()

    if userChoice != '-1':
      print('in fas')
      addedScore = generateQuestion()
      updateUserPoints(newUser, username, addedScore)
    else:
      print("Exiting program...")
      break

except:
  print("Error, exiting program")
