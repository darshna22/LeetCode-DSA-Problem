package java_problem.company_test
/*
* Here first constructor initialize then
* init will execute then constructor statements will execute.
* */
class Example(private var s: String) {
    constructor(a: String, c: String) : this(a) {
        this.s += c
        println(this.s)
    }

    init {
        s += "B"
        println(s)

    }
}

fun main() {
    Example("A", "C")
}

/*
*
* output
* AB
* ABC
*
* */