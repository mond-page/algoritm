import kotlin.math.max

class Q485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxRepeatNumber = 0
        var repeatNumber = 0

        for (num in nums) {
            if (num == 1)
                repeatNumber++
            else {
                maxRepeatNumber = max(maxRepeatNumber, repeatNumber)
                repeatNumber = 0
            }
        }

        return max(maxRepeatNumber, repeatNumber)
    }
}