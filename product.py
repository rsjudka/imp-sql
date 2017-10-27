import random

word_file = "words.txt"
word_list = open(word_file).read().splitlines()
vendor = ['PG','MK','DE','LS','BP']
category = ['CP','FW','GQ','AS']

f = open('product.csv', 'w')
f.write('ProductID,ProductName,ProductPrice,VendorID,CategoryID\n')
for x in range(1,1000001):
    f.write(str(x) + 'X' + str(x) + ',' + 
    random.choice(word_list) + ' ' + 
    random.choice(word_list) + ',' + 
    str(random.randrange(1, 999)) + ',' +
    random.choice(vendor) + ',' +
    random.choice(category) + '\n')
f.close()