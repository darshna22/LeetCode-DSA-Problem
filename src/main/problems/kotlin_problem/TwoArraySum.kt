package kotlin_problem

/*
* oding problem 2
2 input lists / array , which have numbers stored in reverse .
* for eg 342 is stored as L1 = [2,4,3]  and 465 is stored as  L2= [5,6,4]  .
* Please create a new array which has 342 + 465 = 807 stored as [7,0,8]  .
* */
object TwoArraySum {
    @JvmStatic
    fun main(args: Array<String>) {
        val l1 = intArrayOf(2, 4, 3)
        val l2 = intArrayOf(5, 6, 9)
        var l3 = mutableListOf<Int>()
        var carry = 0
        val n = maxOf(l1.size, l2.size)
        var i = 0
        while (i < n) {
            val value1 = if (i < l1.size) l1[i] else 0
            val value2 = if (i < l2.size) l2[i] else 0
            var sum = value1 + value2 + carry
            if (sum >= 10) {
                carry = sum / 10
                sum = sum % 10
            }
            l3.add(sum)
            i++
        }
        if (carry != 0)
            l3.add(carry)
        l3.toIntArray()
        println(l3)
        println(l3.asReversed())
    }
}