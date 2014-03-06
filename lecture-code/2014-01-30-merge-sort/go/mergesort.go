package main

import (
    "fmt"
    "os"
    "strconv"
    "helper"
)

func sort(array []string) []string {
    if len(array) <= 1 {
        return array
    }
    var (
        n = len(array)
        firsthalf = array[0:n/2]
        secondhalf = array[n/2:n]
    )
    return merge(sort(firsthalf), sort(secondhalf))
}

func merge(array1, array2 []string) []string {
    array3 := make([]string, len(array1) + len(array2))
    p1, p2, p3 := 0, 0, 0
    for {
        if array1[p1] <= array2[p2] {
            array3[p3] = array1[p1]
            p3 += 1
            p1 += 1
        } else if array1[p1] > array2[p2] {
            array3[p3] = array2[p2]
            p3 += 1
            p2 += 1
        }
        if p1 == len(array1) {
            arraycopy(array3, p3, array2, p2)
            break
        }
        if p2 == len(array2) {
            arraycopy(array3, p3, array1, p1)
            break
        }
    }

    return array3
}

func arraycopy(target []string, j int, source []string, i int) {
    q := j
    for p:=i; p < len(source); p++ {
        target[q] = source[p]
        q += 1
    }
}

func main() {
    if len(os.Args) != 3 {
        fmt.Println("Usage: <strlen> <arrlen>")
        os.Exit(0)
    }
    strlen, _ := strconv.Atoi(os.Args[1])
    arrlen, _ := strconv.Atoi(os.Args[2])

    helper.ResetTimer()
    array := helper.MakeArray(strlen, arrlen)
    t := helper.ReadTimerMilliseconds()
    fmt.Printf("Sorted in %d ms\n", t)
    fmt.Println(sort(array))
}
