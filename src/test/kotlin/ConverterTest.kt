package app

import org.demo.convert
import kotlin.test.Test
import kotlin.test.assertEquals

class ConverterTest {

    @Test
    fun createDiv() {
        val input = """<div>Hello world</div>""".trimIndent()


        val expectedOutput = """
            div {
                +"Hello world"
            }
            
        """.trimIndent()

        val output = convert(input)

        assertEquals(expectedOutput, output)
    }
}