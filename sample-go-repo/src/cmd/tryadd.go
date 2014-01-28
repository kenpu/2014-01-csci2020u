package main

import (
    "fmt"
    "numbers"
)

func main() {
    fmt.Println("2+3=", numbers.Add2(2,3))
    fmt.Println("1+2+3=", numbers.Add3(1,2,3))
    fmt.Println("1+2+3+4=", numbers.AddAll(1,2,3,4))
}
