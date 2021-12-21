package programmers

class Q42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        val dueDateArr = arrayListOf<Int>()

        for(i in progresses.indices) {
            var dueDate = if ((100 - progresses[i]) % speeds[i] == 0)
                (100 - progresses[i]) / speeds[i]
            else
                (100 - progresses[i]) / speeds[i] + 1

            dueDateArr.add(dueDate)
        }

        var releaseSize = dueDateArr[0]
        var count = 0

        dueDateArr.map { number ->
            if (releaseSize < number) {
                releaseSize = number
                answer.add(count)
                count = 0
            }
            count++
        }

        answer.add(count)

        return answer.toIntArray()
    }
}


fun main() {
    val q42586 = Q42586()
    val progresses = intArrayOf(96, 94)
    val speeds = intArrayOf(3, 3)

    q42586.solution(progresses, speeds)
}