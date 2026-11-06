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
 * The rules are tuned for Portuguese so the result stays easy (and funny) to read:
 * - final vowels get "r" ("casa" -> "casar", "pão" -> "pãor");
 * - final "r" gets another "r" ("falar" -> "falarr");
 * - final "l" becomes "r" ("Brasil" -> "Brasir", "possível" -> "possíver");
 * - final "s" becomes "r" ("pães" -> "pãer", "casas" -> "casar"), except "-ns" which gets "er"
 *   ("parabéns" -> "parabénser");
 * - final "m" becomes "nher" in words with one vowel ("bem" -> "benher"), and loses the "m" in
 *   longer words ("homem" -> "homer", "falam" -> "falar");
 * - other final consonants get "er" ("feliz" -> "felizer", "tórax" -> "tóraxer").
 *
 * All-uppercase words with more than one letter use uppercase replacements ("BEM" -> "BENHER").
 * A single-letter word is treated as capitalized, not as an acronym ("É" -> "Ér", "M" -> "Mr").
 */
fun applyTo(word: String): String? {
    if (word.isEmpty() || !word.last().isLetter()) return null
    val letters = word.filter { it.isLetter() }
    if (letters.isEmpty()) return null
    val allCaps = letters.length > 1 && letters.all { it.isUpperCase() }
    val suffix = if (allCaps) "R" else "r"
    val last = word.last().lowercaseChar()

    // Single-letter words are capitalized words, not acronyms.
    if (letters.length == 1) return word + suffix

    return when {
        last == 'm' -> {
            val vowelCount = letters.count { it.lowercaseChar() in VOWELS }
            if (vowelCount <= 1) word.dropLast(1) + if (allCaps) "NHER" else "nher"
            else word.dropLast(1) + suffix
        }
        last == 'l' -> word.dropLast(1) + suffix
        last == 's' && word.endsWith("ns", ignoreCase = true) ->
            word + if (allCaps) "ER" else "er"
        last == 's' -> word.dropLast(1) + suffix
        last == 'r' -> word + suffix
        last in VOWELS -> word + suffix
        last in CONSONANTS -> word + if (allCaps) "ER" else "er"
        else -> word + suffix
    }
}
