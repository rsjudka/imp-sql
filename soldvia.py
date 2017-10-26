import random

f = open('soldvia.csv', 'w')
f.write('ProductID,TID,NoOfItems\n')
for x in range(2000000):
    temp = random.randrange(1,2000000)
    f.write(str(temp) + 'X' + str(temp) + ',' +
            'T' + str(random.randrange(100,999)) + ',' +
             str(random.randrange(1,100)) + '\n')
f.close()