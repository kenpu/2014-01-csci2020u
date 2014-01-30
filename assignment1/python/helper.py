import time
import random

START = time.time()

def resetTimer():
    global START
    START = time.time()

def readTimerMilliseconds():
    t = time.time() - START
    return round(t * 1000)

def makeArray(strlen, arrlen):
    arr = []
    rand = random.Random()
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    for i in range(arrlen):
        s = "".join(rand.choice(alphabet) for j in range(strlen))
        arr.append(s)
    return arr

