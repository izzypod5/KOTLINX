package org.demo

import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser

fun convert(input: String): String {
    val output = ""
    val handler = KsoupHtmlHandler.Builder().build()
    val parser = KsoupHtmlParser(handler)
    parser.write(input)
    parser.end()
    return output
}

