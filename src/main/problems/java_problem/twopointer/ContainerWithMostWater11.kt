package java_problem.twopointer

object ContainerWithMostWater11 {
    @JvmStatic
    fun main(args: Array<String>) {
        val list = intArrayOf(1,8,6,2,5,4,8,3,7)
        val ls = maxArea(list)
        println(ls)
    }

    fun maxArea(height: IntArray): Int {
        val n = height.size
        var start = 0
        var end = n - 1
        var max = 0
        while (start < end) {
            val minHeight = Math.min(height[start], height[end])
            val towerDiff = end - start
            val waterCapacity = towerDiff * minHeight
            if (max < waterCapacity) max = waterCapacity
            //find next max tower height
            if (height[end] > height[start]) start++ else end--
        }
        return max
    }
}