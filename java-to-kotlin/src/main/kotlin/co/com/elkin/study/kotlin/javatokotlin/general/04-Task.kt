package co.com.elkin.study.kotlin.javatokotlin.general

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    if (secret == guess) return Evaluation(4, 0)

    var rightPosition = 0
    var wrongPosition = 0

    val secretMap = mutableMapOf<Char, Int>()
    for (character in secret) secretMap[character] = secretMap.getOrDefault(character, 0) + 1

    for ((index, character) in guess.withIndex()) {
        if (character == secret[index]) {
            secretMap[character] = secretMap[character]!! - 1
            rightPosition++
        } else if (secretMap.getOrDefault(character, 0) != 0) {
            wrongPosition++
        }
    }
    wrongPosition
    return Evaluation(rightPosition, wrongPosition)

}