// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

// # Suppose we have a series of people relationships that looks something like this:
// #        [    ['Bart',  'brother',   'Lisa'    ],
// #            ['Bart',  'son',      'Homer'    ],
// #            ['Marge', 'wife',     'Homer'    ],
// #            ['Lisa',  'daughter', 'Homer'   ]    ]
// #    
// #        i.e. inner lists have len == 3 and are in form name1, relationship, name2
// #
// # Given a series of relationships as a list of lists, and given two names, return
// # all known "sequences" of relationships from name1 to name2
// # 
// # e.g. with the lists above as input, with input names 'Bart' and 'Homer', you should return:
// #    ['Bart son Homer', 'Bart brother Lisa daughter Homer']
// #

// Iterate through list of lists
// [ ['Bart', 'son', 'Homer'], ['Bart',  'brother',   'Lisa']]
// if sublist[0] === name1, then create string that will be appended to the result,
// but if name2 !== sublist[2], iterate again and append to the string. 


function sequences(list, name1, name2) {
    const result = [];
    const originalName1 = name1;
    
    function scan(list, name1, name2, oldCurrent = '') {
        
        let current = '';
        for (let i = 0; i < list.length; i++) {
            let subList = list[i];
            if (subList[0] === name1) {
                current = subList[0] + ' ' + subList[1] + ' ' + subList[2];
                if (subList[2] !== name2) {
                    scan(list, subList[2], name2, current);
                } else {
                    oldCurrent += ' ' + current;
                    result.push(oldCurrent);
                    if (name1 !== originalName1) return;
                }
            }
            current = '';
        }
        
        return current;
    }
    
    scan(list, name1, name2);
    //console.log("result: ", result);
    return result;
}

console.log(sequences([['Bart',  'brother',   'Lisa'    ],
            ['Bart',  'son',      'Homer'    ],
            ['Marge', 'wife',     'Homer'    ],
           ['Lisa',  'daughter', 'Homer'   ]],
           "Bart", "Homer"));