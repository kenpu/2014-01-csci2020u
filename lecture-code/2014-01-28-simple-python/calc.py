result = []
for x in range(100):
    for y in range(100):
        if 10 < 3*x-y and 3*x-y < 15:
            result.append((x,y))

print sorted(result)
print "Total solution count = %d" % len(result)

