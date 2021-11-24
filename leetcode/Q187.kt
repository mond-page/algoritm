class Q187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        val defaultSize = 10
        val n = s.length

        val seen = HashSet<String>()
        val result = HashSet<String>()

        for ( start in 0..(n - defaultSize) step 1 ) {
            val tmp = s.subSequence(start, start + defaultSize).toString()
            if (seen.contains(tmp))
                result.add(tmp)
            seen.add(tmp)
        }

        return result.toList()

//        var convertDigit = HashSet<Long>()
//        var result = HashSet<Long>()
//
//        for ( str in s.indices ) {
//            if ( str + 10 <= s.length) {
//                var dna: Long = (s[str].code.toLong() * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+1].code.toLong() * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+2].code.toLong() * 2L * 2L * 2L * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+3].code.toLong() * 2L * 2L * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+4].code.toLong() * 2L * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+5].code.toLong() * 2L * 2L * 2L * 2L * 2L)
//                    .plus(s[str+6].code.toLong() * 2L * 2L * 2L * 2L)
//                    .plus(s[str+7].code.toLong() * 2L * 2L * 2L)
//                    .plus(s[str+8].code.toLong() * 2L * 2L)
//                    .plus(s[str+9].code.toLong() * 2L)
//
//                if (convertDigit.contains(dna))
//                    result.add(dna)
//                convertDigit.add(dna)
//            }
//        }
//
//       return result.map {
//            var digitToString: String = ""
//            var number = it
//            var digit = 1L
//            for ( i: Int in 10 downTo 1 ) {
//                for (i in i downTo 1 ) {
//                    digit *= 2
//                }
//                digitToString = digitToString.plus(number.div(digit).toInt().toChar())
//                number = number.minus(digit)
//                digit = 1L
//            }
//           println(digitToString)
//           digitToString
//
//        }.toList()
    }
}