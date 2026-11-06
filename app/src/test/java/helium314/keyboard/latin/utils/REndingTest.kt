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
        assertEquals("mãer", applyTo("mãe"))
    }

    @Test
    fun preservesUppercaseWords() {
        assertEquals("CASAR", applyTo("CASA"))
        assertEquals("Casar", applyTo("Casa"))
        assertEquals("casar", applyTo("casa"))
    }

    @Test
    fun singleLetterWordsUseLowercaseSuffix() {
        assertEquals("ér", applyTo("é"))
        assertEquals("Ér", applyTo("É"))
        assertEquals("ar", applyTo("a"))
        assertEquals("Ar", applyTo("A"))
        assertEquals("Er", applyTo("E"))
        assertEquals("Or", applyTo("O"))
        assertEquals("Mr", applyTo("M"))
        assertEquals("Sr", applyTo("S"))
    }

    @Test
    fun handlesFinalM() {
        assertEquals("benher", applyTo("bem"))
        assertEquals("Benher", applyTo("Bem"))
        assertEquals("BENHER", applyTo("BEM"))
        assertEquals("senher", applyTo("sem"))
        assertEquals("enher", applyTo("em"))
        assertEquals("tênher", applyTo("têm"))
        assertEquals("vênher", applyTo("vêm"))

        // Longer words lose the final "m" and get "r".
        assertEquals("tambér", applyTo("também"))
        assertEquals("homer", applyTo("homem"))
        assertEquals("Homer", applyTo("Homem"))
        assertEquals("HOMER", applyTo("HOMEM"))
        assertEquals("jover", applyTo("jovem"))
        assertEquals("nuver", applyTo("nuvem"))
        assertEquals("viager", applyTo("viagem"))
        assertEquals("onter", applyTo("ontem"))
        assertEquals("alguér", applyTo("alguém"))
        assertEquals("ninguér", applyTo("ninguém"))
        assertEquals("porér", applyTo("porém"))
        assertEquals("falar", applyTo("falam"))
        assertEquals("comer", applyTo("comem"))
        assertEquals("parter", applyTo("partem"))
    }

    @Test
    fun handlesFinalL() {
        assertEquals("Brasir", applyTo("Brasil"))
        assertEquals("BRASIR", applyTo("BRASIL"))
        assertEquals("Portugar", applyTo("Portugal"))
        assertEquals("possíver", applyTo("possível"))
        assertEquals("fácir", applyTo("fácil"))
        assertEquals("animar", applyTo("animal"))
        assertEquals("quar", applyTo("qual"))
        assertEquals("sor", applyTo("sol"))
        assertEquals("mar", applyTo("mal"))
        assertEquals("azur", applyTo("azul"))
    }

    @Test
    fun handlesFinalS() {
        assertEquals("pãer", applyTo("pães"))
        assertEquals("limõer", applyTo("limões"))
        assertEquals("mãor", applyTo("mãos"))
        assertEquals("cãer", applyTo("cães"))
        assertEquals("casar", applyTo("casas"))
        assertEquals("florer", applyTo("flores"))
        assertEquals("animair", applyTo("animais"))
        assertEquals("papéir", applyTo("papéis"))
        assertEquals("heróir", applyTo("heróis"))
        assertEquals("possíveir", applyTo("possíveis"))
        assertEquals("mar", applyTo("mas"))
        assertEquals("gár", applyTo("gás"))
        assertEquals("paír", applyTo("país"))
        assertEquals("vocêr", applyTo("vocês"))
        assertEquals("trêr", applyTo("três"))

        // "-ns" keeps the "er" suffix.
        assertEquals("parabénser", applyTo("parabéns"))
        assertEquals("benser", applyTo("bens"))
        assertEquals("homenser", applyTo("homens"))
        assertEquals("jovenser", applyTo("jovens"))
    }

    @Test
    fun addsEToOtherFinalConsonants() {
        assertEquals("felizer", applyTo("feliz"))
        assertEquals("rapazer", applyTo("rapaz"))
        assertEquals("tóraxer", applyTo("tórax"))
        assertEquals("hífener", applyTo("hífen"))
        assertEquals("player", applyTo("play"))
        assertEquals("rocker", applyTo("rock"))
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
