package br.com.capyensina.main.database

import br.com.capyensina.main.Main
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

class Database(main: Main) {

    init {
        sendGet()
    }

    fun sendGet() {
        val url = URL("https://www.google.com/")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            val reader: BufferedReader = inputStream.bufferedReader()
            var line: String? = reader.readLine()
            while (line != null) {
                System.out.println(line)
                line = reader.readLine()
            }
            reader.close()
        }
    }
}
