package leetcode

import kotlin.math.max

class Q135 {
    fun candy(ratings: IntArray): Int {
        var sum = 0
        var miniumLeft = IntArray(ratings.size) { 1 }
        var miniumRight = IntArray(ratings.size) { 1 }

        // left start
        for (idx in ratings.indices) {
            if (idx == ratings.size -1)
                break

            if (ratings[idx] < ratings[idx+1])
                miniumLeft[idx+1] = miniumLeft[idx] +1
            else
                miniumLeft[idx+1] = 1
        }

        // right start
        for (idx in ratings.indices.reversed()) {
            if (idx == 0)
                break

            if (ratings[idx-1] > ratings[idx])
                miniumRight[idx-1] = miniumRight[idx] + 1
            else
                miniumRight[idx-1] = 1
        }

        for (idx in miniumLeft.indices) {
            sum += max(miniumLeft[idx], miniumRight[idx])
        }

        return sum
    }
}


fun main() {
    val q135 = Q135()

    val ratings = intArrayOf(1,0,2)
    println(q135.candy(ratings))
}