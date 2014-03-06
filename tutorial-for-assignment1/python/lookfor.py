#
# Given a file and a keyword, look for all the lines in that file
# containing the keyword
#

import sys
import time

if not len(sys.argv[1:]) == 2:
    print "Usage <file> <keyword>"
    sys.exit()

filename, keyword = sys.argv[1:3]

print "=" * 60
print 'Looking for "%s" in the file "%s"' % (keyword, filename)
print "=" * 60

try:
    f = open(filename, "r")
except:
    print 'Cannot open file "%s"' % filename
    sys.exit()

start = time.time()
count = 0
for line in f.readlines():
    if keyword in line:
        print line.strip()
        count +=1

print "=" * 60
print "Found %d instances in %.4f seconds" % (count, time.time() - start)
f.close()
