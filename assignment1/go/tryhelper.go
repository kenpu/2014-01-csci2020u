package main

import (
    "fmt"
    "helper"
)

func main() {
    arrlen := 20
    strlen := 10
    helper.ResetTimer()
    array := helper.MakeArray(strlen, arrlen)
    t := helper.ReadTimerMilliseconds()
    fmt.Printf("Generated %d strings of length %d in %.4f ms\n",
                arrlen, strlen, t)
    for _, x := range(array) {
        fmt.Println(x)
    }
}
