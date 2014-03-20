package main

import (
    "os"
    "fmt"
    "net"
    "bufio"
    "strings"
)

func handle(conn net.Conn) {
    reader := bufio.NewReader(conn)
    line, err := reader.ReadString('\n')
    for {
        if err != nil {
            fmt.Println("Read error:", err.Error())
            break
        }
        fmt.Println("Received:", line)
        if strings.Contains(line, "bye") {
            break
        }
        reply := fmt.Sprintf("(go) you have said \"%s\".", line)
        fmt.Fprintln(conn, reply)
        line, err = reader.ReadString('\n')
    }
}

func main() {
    main, err := net.Listen("tcp", ":2002")
    if err != nil {
        fmt.Println("Error:", err.Error())
        os.Exit(0)
    }
    for {
        fmt.Println("Accepting incoming connections...")
        conn, err := main.Accept()
        fmt.Println("Connection made")

        if err != nil {
            fmt.Println("Error:", err.Error())
        } else {
            handle(conn)
            conn.Close()
        }
    }
}
