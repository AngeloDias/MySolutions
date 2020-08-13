package solutions

class CheckIfTheLettersAreJumbled {
    companion object {

        /**
         * This solution assumes that the problem isn't case sensitive.
         * */
        fun isOneStringPartialPermutation(defaultStr: String, checkingStr: String): Boolean {
            if ((defaultStr.isEmpty() || checkingStr.isEmpty())
                || defaultStr.length != checkingStr.length
                || defaultStr.toLowerCase()[0] != checkingStr.toLowerCase()[0]
            ) {
                return false
            }

            val defaultLowerCase = defaultStr.toLowerCase()
            val checkingLowerCase = checkingStr.toLowerCase()
            var countDiff = 0

            /**
             * To determine if a checking string is permutation it's a must to count the amount of
             * letters displaced.
             * */
            for (i in defaultLowerCase.indices) {
                if(checkingLowerCase[i] != defaultLowerCase[i] && i+1 < defaultLowerCase.length
                    && checkingLowerCase[i] != defaultLowerCase[i+1]) {
                    countDiff++
                }

                if (countDiff > 2) {
                    return false
                }
            }

            return true
        }
    }

}
