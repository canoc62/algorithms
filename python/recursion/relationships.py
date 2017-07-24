# Suppose we have a series of people relationships that looks something like this:
#        [    ['Bart',  'brother',   'Lisa'    ],
#            ['Bart',  'son',      'Homer'    ],
#            ['Marge', 'wife',     'Homer'    ],
#            ['Lisa',  'daughter', 'Homer'   ]    ]
#    
#        i.e. inner lists have len == 3 and are in form name1, relationship, name2
#
# Given a series of relationships as a list of lists, and given two names, return
# all known "sequences" of relationships from name1 to name2
# 
# e.g. with the lists above as input, with input names 'Bart' and 'Homer', you should return:
#    ['Bart son Homer', 'Bart brother Lisa daughter Homer']
#

def getRelationships(relList, name1, name2):
  result = []
  originalName = name1

  def scan(relList, name1, name2, relationship = ''):
    if relationship != '':
      relationship += ' '

    for i in range(len(relList)):
      currentRelationship = relList[i]
      if currentRelationship[0] == name1:
        relationship += currentRelationship[0] + ' ' + currentRelationship[1]
        if currentRelationship[2] == name2:
          relationship += ' ' + currentRelationship[2]
          result.append(relationship)
          if name1 != originalName:
            return
        else:
          scan(relList, currentRelationship[2], name2, relationship)
          relationship = ''
    return result

  return scan(relList, name1, name2)


rels = [['Bart', 'brother', 'Lisa'], ['Bart', 'son', 'Homer'],\
       ['Marge', 'wife', 'Homer'], ['Lisa', 'daughter', 'Homer']]

print(getRelationships(rels, 'Bart', 'Homer'))

  
   