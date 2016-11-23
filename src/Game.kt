class Game {
    val rolls = IntArray(21) {0}
    var currentRoll = 0

    val score : Int
        get() {
            var score = 0
            var frameIndex = 0
            (1..10).forEach {
                when {
                    isSpare(frameIndex) -> {
                        score += scoreSpare(frameIndex)
                        frameIndex += 2
                    }
                    isStrike(frameIndex) -> {
                        score += scoreStrike(frameIndex)
                        frameIndex++
                    }
                    else -> {
                        score += scoreFrame(frameIndex)
                        frameIndex += 2
                    }
                }
            }

            return score
        }

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    private fun scoreStrike(frameIndex: Int) = 10 + strikeBonus(frameIndex)

    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]

    private fun scoreSpare(frameIndex: Int) = scoreFrame(frameIndex) + spareBonus(frameIndex)

    private fun  spareBonus(frameIndex: Int) = rolls[frameIndex + 2]

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10

    private fun isSpare(frameIndex: Int) = scoreFrame(frameIndex) == 10

    private fun scoreFrame(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]
}