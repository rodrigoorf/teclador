// SPDX-License-Identifier: GPL-3.0-only
@file:JvmName("REnding")

package helium314.keyboard.latin.utils

/**
 * Returns [word] with the joke "R" appended, or null when no R should be appended.
 *
 * The R is only appended to words that end with a letter. Words that are entirely uppercase get
 * an uppercase R; everything else gets a lowercase r. This deliberately does not special-case
 * words that already end in R, so "falar" becomes "falarr".
 */
fun appendTo(word: String): String? {
    if (word.isEmpty() || !word.last().isLetter()) return null
    val letters = word.filter { it.isLetter() }
    if (letters.isEmpty()) return null
    val r = if (letters.all { it.isUpperCase() }) 'R' else 'r'
    return word + r
}
