package leetcode


/**
 *  피보나치 수열
 *  [+] 시간복잡도 : O(n)
 *  [+] 공간복잡도 : O(n)
 */
class Q70 {
    fun climbStairs(n: Int): Int {
        val numArr = IntArray(n+1)

        for (stair in 1..n) {
            if (stair == 1 || stair == 2) {
                numArr[stair] = stair
            } else {
                numArr[stair] = numArr[stair -2] + numArr[stair - 1]
            }
        }

        return numArr[n]
    }
}

fun main() {
    val q70 = Q70()

    println(q70.climbStairs(45))

}


