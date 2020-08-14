package solutions

class CheckTypo {

    /**
     * I decided to use "companion object" to facilitate code testing.
     * */
    companion object {

        /**
         * This solution assumes that the strings provided will be in lower case.
         * Therefore, no case-sensitive checks have been implemented.
         * */
        fun isZeroOrOneTypo(stringA: String, stringB: String): Boolean {
            if (stringA.length > stringB.length) {
                return checkTypoBy(stringA, stringB)
            } else if(stringA.length < stringB.length) {
                return checkTypoBy(stringB, stringA)
            }

            return wereStringsEditedAtMostOneLetter(stringA, stringB)
        }

        private fun checkTypoBy(biggerStr: String, smallerStr: String): Boolean {
            /**
             * The two strings can differ by a maximum of one letter.
             * */
            if (biggerStr.length - 1 > smallerStr.length) {
                return false
            }

            /**
             * Indexes to check simultaneously if the characters are in the same order.
             * */
            var indexBigger = 0
            var indexSmaller = 0

            /**
             * To monitor the displaced character.
             * */
            var foundAway = false

            while (indexBigger < biggerStr.length && indexSmaller < smallerStr.length) {

                /**
                 * When the displaced character is found, then it can only occur once.
                 * */
                if (biggerStr[indexBigger] != smallerStr[indexSmaller]) {

                    if (foundAway) {
                        return false
                    }

                    foundAway = true
                    indexBigger += 1
                } else {
                    indexBigger += 1
                    indexSmaller += 1
                }

            }

            /**
             * Means that the string was completely checked.
             * */
            return true
        }

        /**
         * Used when the strings are the same length.
         * */
        private fun wereStringsEditedAtMostOneLetter(strA: String, strB: String): Boolean {
            if(strA.length != strB.length) {
                return false
            }

            var oneAway = false

            for(i in strA.indices) {
                if(strA[i] != strB[i]) {
                    if(oneAway) {
                        return false
                    }

                    oneAway = true
                }
            }

            return true
        }

    }

}
