package leetcode

class Q39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        backTracking(candidates, 0, target, arrayListOf(), result)

        return result
    }

    private fun backTracking(candidates: IntArray, startIdx: Int, target: Int, combination: ArrayList<Int>, result: ArrayList<ArrayList<Int>>) {
        if (target < 0)
            return
        else if (target == 0) {
            result.add(ArrayList(combination))
            return 
        }

        for (idx in startIdx until candidates.size) {
            combination.add(candidates[idx])
            backTracking(candidates, idx, target.minus(candidates[idx]), combination, result)
            combination.removeAt(combination.size - 1)
        }
    }
}

fun main() {

    val q39: Q39 = Q39()

    val candidates = intArrayOf(2,3,6,7)
    println(q39.combinationSum(candidates, 7))
}