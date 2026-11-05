// SPDX-License-Identifier: GPL-3.0-only
package helium314.keyboard.latin.utils

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class REndingTest {
    @Test
    fun appendsLowercaseR() {
        assertEquals("casar", applyTo("casa"))
        assertEquals("falarr", applyTo("falar"))
        assertEquals("pãor", applyTo("pão"))
        assertEquals("manhãr", applyTo("manhã"))
    }

    @Test
    fun preservesUppercaseWords() {
        assertEquals("CASAR", applyTo("CASA"))
        assertEquals("Casar", applyTo("Casa"))
        assertEquals("casar", applyTo("casa"))
    }

    @Test
    fun handlesFinalM() {
        assertEquals("benher", applyTo("bem"))
        assertEquals("Benher", applyTo("Bem"))
        assertEquals("BENHER", applyTo("BEM"))
        assertEquals("tambénher", applyTo("também"))
        assertEquals("homenher", applyTo("homem"))
        assertEquals("falanher", applyTo("falam"))
    }

    @Test
    fun addsEToOtherFinalConsonants() {
        assertEquals("Brasiler", applyTo("Brasil"))
        assertEquals("felizer", applyTo("feliz"))
        assertEquals("maser", applyTo("mas"))
        assertEquals("parabénser", applyTo("parabéns"))
        assertEquals("hífener", applyTo("hífen"))
        assertEquals("tóraxer", applyTo("tórax"))
        assertEquals("player", applyTo("play"))
    }

    @Test
    fun ignoresNonWordsAndEmptyStrings() {
        assertNull(applyTo(""))
        assertNull(applyTo("123"))
        assertNull(applyTo("..."))
        assertNull(applyTo("casa."))
        assertNull(applyTo("🙂"))
    }
}
