package main

import (
    "fmt"
    "time"
)

func main() {
    var channels [5]chan string

    for i:=0; i < 5; i++ {
        channels[i] = make(chan string)
        go func(c chan string) {
            msg := <-c  // read the message to print
            for j:=0; j < 100; j++ {
                fmt.Printf("[%d]%s\n", j, msg)
                time.Sleep(10 * time.Millisecond)
            }
            c <- "done"
        }(channels[i])
        channels[i] <- fmt.Sprintf("Hello from [%d]", i)
    }

    for i, c := range channels {
        msg := <-c
        fmt.Printf("go routine [%d] is done: %s\n", i, msg)
    }
}
