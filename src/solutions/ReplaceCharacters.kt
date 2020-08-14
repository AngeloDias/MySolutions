package solutions

class ReplaceCharacters {

    /**
     * I decided to use "companion object" to facilitate code testing.
     * */
    companion object {

        fun replaceInPlace(str: Array<Char>, trueStrLength: Int): Array<Char> {
            var limit = trueStrLength + 1

            for (i in (trueStrLength - 1) downTo 0) {

                if (str[i] == ' ') {
                    var threeTimes = 0

                    //    “User is not allowed“, 19
                    //    “User&32is&32not&32allowed”

                    while (threeTimes < 3) {

                        when (threeTimes) {
                            0 -> {
                                str[i] = '&'
                            }
                            else -> {
                                var iterate = i + threeTimes
                                var curr = str[iterate]

                                if(threeTimes == 1) {
                                    str[i + threeTimes] = '3'
                                } else {
                                    str[i + threeTimes] = '2'
                                }

                                while (iterate + 1 <= limit) {

                                    val temp = str[iterate + 1]
                                    str[iterate + 1] = curr
                                    curr = temp

                                    iterate++
                                }

                            }
                        }

                        threeTimes++
                    }

                    limit += 2
                }
            }

            return str
        }

    }

}
