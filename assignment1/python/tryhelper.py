import helper

helper.resetTimer()
arr = helper.makeArray(40, 1000)
t = helper.readTimerMilliseconds()

print "===== took: %d ms =========" % t
print "\n".join(arr)

