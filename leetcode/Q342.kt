package leetcode

class Q342 {
    fun isPowerOfFour(n: Int): Boolean {
        var num = n
        if (num == 0)
            return false
        while ( num % 4 == 0)
            num /= 4

        return num == 1
    }
}

fun main() {
    val q342 = Q342()

    println(q342.isPowerOfFour(1162261466))
}