import sys

filename = sys.argv[1]

f = open(filename, "r")

# map from words to integer count
counts = {}

for line in f.readlines():
    words = line.split()
    for w in words:
        counts[w] = 1 if not w in counts else counts[w]+1

ranked = sorted(counts.keys(), key=lambda x: counts[x], reverse=True)

print "There are %d distinct words" % len(counts)

for w in ranked[:100]:
    print '"%s" %d' % (w, counts[w])

