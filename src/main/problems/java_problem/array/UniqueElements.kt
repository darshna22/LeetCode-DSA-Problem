package java_problem.array

fun main(){
    val list = listOf('a', 'A', 'b', 'B', 'A', 'a')
    println(list.toMutableSet())
    println(list.distinct())
    val list1=list.map { it->it.toLowerCase() }
    println(list1)
}