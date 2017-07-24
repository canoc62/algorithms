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
