package main

import (
    "fmt"
    "os"
    "bufio"
    "strings"
    "sort"
)

// This is a (Word, Count) pair, similar to java.util.Map.Entry
type Entry struct {
    Word string
    Count int
}

// This is the list of entries to be sorted
type Entries []Entry

// Entries must implement sort.Interface
func (list Entries) Len() int {
    return len(list)
}
func (list Entries) Less(i, j int) bool {
    return list[j].Count < list[i].Count
}
func (list Entries) Swap(i, j int) {
    list[i], list[j] = list[j], list[i]
}

func main() {
    if len(os.Args) != 2 {
        fmt.Println("Usage: <filename>");
        os.Exit(0)
    }

    var (
        counts    = make(map[string]int)
        filename  = os.Args[1]
    )

    // Open the file for I/O
    f, err := os.Open(filename)
    defer f.Close()
    if err != nil {
        fmt.Printf("Cannot open file \"%s\"\n", filename)
        os.Exit(0)
    }
    reader := bufio.NewReader(f)

    // build the counting map
    line, err := reader.ReadString('\n')
    for err == nil {
        for _, w := range(strings.Fields(line)) {
            count, present := counts[w]
            if present {
                counts[w] = count + 1
            } else {
                counts[w] = 1
            }
        }
        line, err = reader.ReadString('\n')
    }

    fmt.Printf("There are %d distinct words found.\n", len(counts))

    // rank the (word,count) pairs by building
    // a Entries object, and invoke sort.Sort(...)
    var list Entries = make([]Entry, len(counts))
    i := 0
    for w, count := range(counts) {
        list[i] = Entry{w, count}
        i += 1
    }
    sort.Sort(list)

    // display the top 100
    for _, entry := range(list[:100]) {
        fmt.Printf("\"%s\" %d\n", entry.Word, entry.Count)
    }
}
