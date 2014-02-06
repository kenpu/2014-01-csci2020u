
def sort(array):
    if len(array) <= 1:
        return array
    else:
        firsthalf = array[:len(array)/2]
        secondhalf = array[len(array)/2:]
        return merge(sort(firsthalf), sort(secondhalf))

def merge(array1, array2):
    p1, p2 = 0, 0
    array3 = []
    while True:
        if array1[p1] <= array2[p2]:
            array3.append(array1[p1])
            p1 += 1
        elif array1[p1] > array2[p2]:
            array3.append(array2[p2])
            p2 += 1
        if p1 == len(array1):
            array3.extend(array2[p2:])
            break
        if p2 == len(array2):
            array3.extend(array1[p1:])
            break

    return array3
