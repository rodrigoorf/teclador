// SPDX-License-Identifier: GPL-3.0-only
@file:JvmName("REnding")

package helium314.keyboard.latin.utils

// Portuguese vowels, including accented forms. Final "y" is treated as a consonant so that
// words like "play" become "player".
private const val VOWELS = "aeiouáàâãäéèêëíìîïóòôõöúùûüý"

// Consonants that need an epenthetic "e" before the R to stay pronounceable.
private const val CONSONANTS = "bcdfghjklmnpqrstvwxyzç"

/**
 * Returns [word] with the joke "R" ending, or null when [word] does not end with a letter.
 *
 * Most words get an "r" appended. A few Portuguese endings get a small adjustment so the result
 * is easier to read out loud:
 * - final "m" becomes "nher" ("bem" -> "benher", "também" -> "tambénher");
 * - other final consonants get "er" ("Brasil" -> "Brasiler", "feliz" -> "felizer");
 * - final "r" gets another "r" ("falar" -> "falarr");
 * - final vowels get "r" ("casa" -> "casar").
 *
 * All-uppercase words with more than one letter use uppercase replacements ("BEM" -> "BENHER").
 * A single-letter word is treated as capitalized, not as an acronym ("É" -> "Ér").
 */
fun applyTo(word: String): String? {
    if (word.isEmpty() || !word.last().isLetter()) return null
    val letters = word.filter { it.isLetter() }
    if (letters.isEmpty()) return null
    val allCaps = letters.length > 1 && letters.all { it.isUpperCase() }
    val last = word.last().lowercaseChar()
    return when {
        last == 'm' -> word.dropLast(1) + if (allCaps) "NHER" else "nher"
        last == 'r' -> word + if (allCaps) 'R' else 'r'
        last in VOWELS -> word + if (allCaps) 'R' else 'r'
        last in CONSONANTS -> word + if (allCaps) "ER" else "er"
        else -> word + if (allCaps) 'R' else 'r'
    }
}
