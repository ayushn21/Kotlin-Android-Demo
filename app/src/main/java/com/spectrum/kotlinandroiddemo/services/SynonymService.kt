package com.spectrum.kotlinandroiddemo.services

import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

/**
 * Created by Ayush on 05/06/16.
 */

class SynonymService {

    private val endpoint: String
        get() = "http://thesaurus.altervista.org/thesaurus/v1?"
    private val key: String
        get() = "FsVpd7Ha0Q5h49th4SLb"
    private val requestParams: String
        get()  = "key=$key&word=%s&language=en_US&output=json"

    fun retrieveSynonymsForWord(word: String, onCompletion: (synonyms: Array<String>) -> Unit) {
        val formattedParams = String.format(requestParams, word)
        val requestURL = endpoint.plus(formattedParams)

        println("URL: $requestURL")

        async() {
            val result = URL(requestURL).readText()
            uiThread {
                println("Synonyms: ")
                println(result)
            }
        }
    }
}