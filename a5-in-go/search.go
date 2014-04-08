package main

import (
    "os"
    "fmt"
    "time"
    "bufio"
    "strings"
    "strconv"
)

var N = 9240515

func search(keyword string, filename string, start, end int, c chan int) {
    file, err := os.Open(filename)
    if err != nil {
        fmt.Println("Failed to open file:" + err.Error())
        c <- 0
    }
    var reader *bufio.Reader = bufio.NewReader(file)
    defer file.Close()

    var counter int = 0
    var linenum = 0
    line, err := reader.ReadString('\n')
    for err == nil {
        if start <= linenum && linenum < end && strings.Contains(line, keyword) {
            counter += 1
        }
        line, err = reader.ReadString('\n')
        linenum += 1
    }
    c <- counter
}

func main() {
    if len(os.Args) != 4 {
        fmt.Println("Usage: search <filename> <keywords>")
        return
    }
    var filename string = os.Args[1]
    var keyword  string = os.Args[2]
    K,err := strconv.Atoi(os.Args[3])
    if err != nil {
        fmt.Println("K is not an integer")
        return
    }

    var startTime = time.Now()

    var c = make([]chan int, K)
    for i:=0; i < K; i++ {
        c[i] = make(chan int)
        start := i*N/K
        end   := start + N/K
        go search(keyword, filename, start, end, c[i])
    }
    var counter = 0
    for i := range c {
        counter += <-c[i]
    }

    var endTime = time.Now()
    var duration = endTime.Sub(startTime)
    fmt.Printf("Found %d occurrances in %.2f seconds\n", counter, duration.Seconds())
}
