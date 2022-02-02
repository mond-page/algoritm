package leetcode

class Q217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val numHash: HashSet<Int> = HashSet()

        for (num in nums) {
            if (numHash.contains(num))
                return true
            numHash.add(num)
        }

        return false
    }
}