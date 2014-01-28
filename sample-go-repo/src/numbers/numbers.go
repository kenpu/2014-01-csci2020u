package numbers

func Add2(a int, b int) (c int) {
    c = a + b
    return
}

func Add3(a, b, c int) int {
    return a + b + c
}

func AddAll(a... int) (sum int) {
    for _,x := range(a) {
        sum += x
    }
    return
}

