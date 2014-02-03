package helper

import (
    "time"
    "math/rand"
)

var start = time.Now()

func ResetTimer() {
    start = time.Now()
}

func ReadTimerMilliseconds() float64 {
    var d = time.Now().Sub(start)
    var ms = d.Seconds() * 1000
    return ms
}

var alphabet = "abcdefghijklmnopqrstuvwxyz"

func randString(strlen int) string {
    var x = make([]byte, strlen)
    for i:=0; i < strlen; i++ {
        x[i] = alphabet[rand.Intn(26)]
    }
    return string(x)
}

func MakeArray(strlen, arrlen int) []string {
    var array []string = make([]string, arrlen)
    for i:=0; i < arrlen; i++ {
        array[i] = randString(strlen)
    }
    return array
}
