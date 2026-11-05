// SPDX-License-Identifier: GPL-3.0-only
package helium314.keyboard.latin.utils

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class REndingTest {
    @Test
    fun appendsLowercaseR() {
        assertEquals("casar", appendTo("casa"))
        assertEquals("falarr", appendTo("falar"))
    }

    @Test
    fun preservesUppercaseWords() {
        assertEquals("CASAR", appendTo("CASA"))
        assertEquals("Casar", appendTo("Casa"))
        assertEquals("casar", appendTo("casa"))
    }

    @Test
    fun ignoresNonWordsAndEmptyStrings() {
        assertNull(appendTo(""))
        assertNull(appendTo("123"))
        assertNull(appendTo("..."))
        assertNull(appendTo("casa."))
        assertNull(appendTo("🙂"))
    }
}
