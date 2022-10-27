package kotlin_problem

object ReverseArrayIndexValue {
    @JvmStatic
    fun main(args: Array<String>) {
        val nameList = mutableListOf<String>("darshna", "radhav", "raj", "rani", "priya")
        //var revListName=Array<String>(5)
        for ((index, name) in nameList.withIndex()) {
            val charName = name.toCharArray()
            var start = 0
            var end = name.length - 1
            while (start <= end) {
                val temp = charName[start]
                charName[start] = charName[end]
                charName[end] = temp
                start++
                end--
            }
            nameList[index] = String(charName)
            println(nameList[index])
        }
        nameList.sortWith(NameSort())
        println(nameList)


    }

    class NameSort() : Comparator<String> {
        override fun compare(o1: String?, o2: String?): Int {
            return o1!!.compareTo(o2.toString())
        }
    }
}