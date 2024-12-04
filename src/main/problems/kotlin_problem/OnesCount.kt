package kotlin_problem

/*Coding problem 1
I have a very large array with values either '1' or '0'.
Length of the array is unknown. How do I find the no of occurrences of 1 in this array*/
object OnesCount {
    @JvmStatic
    fun main(args: Array<String>) {
        val intArray = intArrayOf(1, 0, 1, 1, 0, 1, 0, 1)
        println("darshna ${countOnes(intArray)}")
       println("radhav ${countOnes1(intArray)}")
        println("rani ${countOnes2(intArray)}")
        println("raniya ${countOnes3(intArray)}")
    }

    fun countOnes(array: IntArray): Int {
        return array.count { it == 1 }
    }

    fun countOnes1(array: IntArray): Int {
        return array.sum()
    }

    fun countOnes2(array: IntArray): Int {
        return array.filter { it == 1 }.count()
    }

    fun countOnes3(array: IntArray): Int {
        var count=0
        var i=0;
        var j=array.size-1
        while (i<=j){
            if(i==j && array[j]==1 ){
                count++
                i++
                j--
            }
           else if(array[i]==1 && array[j]==1 ){
                count=count+2
                i++
                j--
            }else if(array[i]==1 ){
                count++
                i++

            }else if(array[j]==1 ){
                count++
                j--

            }else{
                i++
                j--
            }
        }
        return count
    }
}