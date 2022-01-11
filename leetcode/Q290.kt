package leetcode

class Q290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val hashMap = HashMap<Char, String>()
        val splitString = s.split(" ")

        if (pattern.length != splitString.size)
            return false

        for (idx in pattern.indices) {
            val char = pattern[idx]

            if (hashMap.containsKey(char)) {
                if (hashMap[char] != splitString[idx]) return false
            } else if (!hashMap.containsKey(char) && hashMap.containsValue(splitString[idx]))
                return false
            else
                hashMap[char] = splitString[idx]
        }
        return true
    }
}


fun main() {
    val q290 = Q290()

    println(q290.wordPattern("abba", "dog gg gg dog"))
}