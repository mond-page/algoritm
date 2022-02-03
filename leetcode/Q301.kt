package leetcode

class Q301 {
    fun removeInvalidParentheses(s: String): List<String> {
        val minRemoveCount = getMinParentheseRemove(s)
        val result = HashSet<String>()

        dfs(s, 0, minRemoveCount, 0, "", result)

        return result.toList()
    }

    private fun dfs(s: String, idx: Int, minRemoveCount: Int, open: Int, temp: String, result: HashSet<String>) {
        if (idx == s.length) {
            if (minRemoveCount == 0 && open == 0)
                result.add(temp)
            return
        } else if (minRemoveCount < 0)
            return

        if(s[idx] == '(') {
            // ( use
            dfs(s, idx + 1, minRemoveCount, open + 1, "$temp(", result)
            // ( not use
            dfs(s, idx + 1, minRemoveCount - 1, open, temp, result)
        } else if (s[idx] == ')') {
            // ( 가 있으면 ) use
            if (open > 0)
                dfs(s, idx + 1, minRemoveCount, open -1, "$temp)", result)
            // ) not use
            dfs(s, idx + 1, minRemoveCount - 1, open, temp, result)
        } else {
            dfs(s, idx + 1, minRemoveCount, open, "$temp${s[idx]}", result)
        }
    }

    private fun getMinParentheseRemove(s: String): Int {
        var minRemoveCount = 0
        var open = 0
        for (c in s) {
            if (c == '(')
                open++
            else if (c == ')') {
                if (open == 0)
                    minRemoveCount++
                else
                    open--
            }
        }

        minRemoveCount += open
        return minRemoveCount
    }
}


fun main () {
    val q301 = Q301()

    val parentheses = ")))))))))"
    println(q301.removeInvalidParentheses(parentheses))
}