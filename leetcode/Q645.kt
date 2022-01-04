package leetcode

import java.util.HashSet

class Q645 {
    fun findErrorNums(nums: IntArray): IntArray {
        var result = IntArray(2)
        val hashSet= HashSet<Int>()

        for(num in 1..nums.size)
            hashSet.add(num)

        for (num in nums) {
            if(!hashSet.contains(num))
                result[0] = num
            else
                hashSet.remove(num)
        }

        result[1] = hashSet.first()

        return result
    }
}


fun main() {
    val q645 = Q645()
    val nums = intArrayOf(3,2,3,4,5,6)

    q645.findErrorNums(nums)
}