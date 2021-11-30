class Q1002 {
    fun commonChars(words: Array<String>): List<String> {
        if (words.size == 1)
            return listOf()

        var chartersArray = IntArray(26 * words.size)
        var result = mutableListOf<String>()

        words.mapIndexed { idx, word ->
            word.map {
                chartersArray[(it.code - 97)  + (26 * (idx))]++
            }
        }

        for (charterIdx in 0..25) {
            val values = mutableListOf<Int>()
            for (wordIdx in words.indices) {
                values.add(chartersArray[charterIdx + (26 * wordIdx)])
            }

            val minChar = Collections.min(values)

            if (minChar > 0) {
                for (count in 0 until minChar)
                    result.add( Char(charterIdx + 97).toString())
            }

        }

        return result
    }
}