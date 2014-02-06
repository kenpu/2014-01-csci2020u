import csci2020u.mergesort as merge
import sys
import helper

if len(sys.argv) == 3:
    strlen = int(sys.argv[1])
    arrlen = int(sys.argv[2])
else:
    print "Usage: <strlen> <arrlen>"
    sys.exit()

array = helper.makeArray(strlen, arrlen)

helper.resetTimer()
array2 = merge.sort(array)
t = helper.readTimerMilliseconds()

print "Sorted everything in %d ms" % t
print "\n".join(array2)
