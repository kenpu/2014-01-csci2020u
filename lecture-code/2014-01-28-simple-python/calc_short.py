results = [(x,y) for x in range(100) \
                 for y in range(100) \
                 if 10 < 3*x-y and 3*x-y < 15]
print sorted(results)
print "Total solution count = %d" % len(results)

