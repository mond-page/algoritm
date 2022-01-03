package leetcode

class Q119 {
    fun getRow(rowIndex: Int): List<Int> {
        val list = arrayListOf(1)

        for (idx in 1..rowIndex) {
            val beforeRowStartIndex = list.size - idx
            var rowArray = IntArray(idx+1)
            for (rowIdx in rowArray.indices) {
                rowArray[rowIdx] = if (rowIdx == 0 || rowIdx == rowArray.size -1) {
                    1
                } else {
                    val num1 = list[beforeRowStartIndex + rowIdx -1]
                    val num2 = list[beforeRowStartIndex + rowIdx]

                    num1 + num2
                }
            }
            if (idx == rowIndex) {
                return rowArray.asList()
            }
            list.addAll(rowArray.toTypedArray())
        }
        return listOf(1)
    }
}

fun main() {
    val q119 = Q119()
    println(q119.getRow(3))
}