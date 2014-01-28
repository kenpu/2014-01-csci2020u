import sys
import os
from datetime import datetime

def print_mtime(filename):
    try:
        info = os.stat(filename)
        d = datetime.fromtimestamp(info.st_mtime)
        print '"%s" last modified %s' % (filename, d.strftime("%Y/%m/%d"))
    except:
        print '"%s" cannot be accessed.' % filename

for filename in sys.argv[1:]:
    print_mtime(filename)
