package main

import (
    "fmt"
    "os"
    "bufio"
    "strings"
    "time"
)

func main() {
    if len(os.Args) != 3 {
        fmt.Println("Usage <filename> <keyword>")
        os.Exit(0)
    }
    filename, keyword := os.Args[1], os.Args[2]

    f, err := os.Open(filename)

    if err != nil {
        fmt.Printf("Cannot open file \"%s\"\n", filename)
        os.Exit(0)
    }

    reader := bufio.NewReader(f)
    start := time.Now()
    count := 0
    for line, err := reader.ReadString('\n');
        err == nil;
        line, err = reader.ReadString('\n') {
        if strings.Contains(line, keyword) {
            fmt.Print(line)
            count += 1
        }
    }
    duration := time.Now().Sub(start)
    fmt.Printf("Found %d instances in %.4f seconds\n",
        count,
        float32(duration.Nanoseconds()) / 10E9)
}
