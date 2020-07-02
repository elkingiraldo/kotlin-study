package co.com.elkin.study.kotlin.javatokotlin.generalweekonetwo

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
            secretMap[character] = secretMap[character]!! - 1
            wrongPosition++
        }
    }
    wrongPosition
    return Evaluation(rightPosition, wrongPosition)

}

fun evaluateGuess2(secret: String, guess: String): Evaluation {
    if (secret == guess) return Evaluation(4, 0)

    var rightPosition = 0
    var wrongPosition = 0

    val rights = mutableListOf<Char>()

    val secretMap = mutableMapOf<Char, Int>()
    for (character in secret) secretMap[character] = secretMap.getOrDefault(character, 0) + 1


    for ((index, character) in guess.withIndex()) {
        if (character == secret[index]) {
            secretMap[character] = secretMap[character]!! - 1
            rights.add(character)
            rightPosition++
        }
    }

    for (character in guess) {
        if (rights.contains(character)) {
            rights.remove(character)
        } else if (secretMap.getOrDefault(character, 0) != 0) {
            secretMap[character] = secretMap[character]!! - 1
            wrongPosition++
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}

fun evaluateGuessFunctionalStyle(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { (a, b) -> a == b }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { singleSecret -> singleSecret == ch }, guess.count { singleGuess -> singleGuess == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

fun evaluateGuessFunctionalStyle2(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }

    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }

    return Evaluation(rightPositions, commonLetters - rightPositions)
}