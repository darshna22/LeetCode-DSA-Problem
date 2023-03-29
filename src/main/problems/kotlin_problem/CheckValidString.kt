package kotlin_problem

import java.util.Stack

/*
* takes in a string of parentheses (e.g. "(()())") and returns true if the parentheses are balanced,
* false otherwise. A string of parentheses is balanced if every opening parenthesis has a matching
* closing parenthesis in the correct order.Example: Input: "(()())" Output: trueInput: "(()(" Output: false
*
*
* */

fun main() {
    val inuptStr = "s()"
    println(isValid(inuptStr))

}

fun isValid(inuptStr: String): Boolean {
    val stack = Stack<Char>()
    var i = 0
    while (i < inuptStr.length) {
        if (inuptStr[i] == '(') {
            stack.push('(')
        } else {
            stack.pop()
        }
        i++;
    }



    return !stack.isNotEmpty()
}