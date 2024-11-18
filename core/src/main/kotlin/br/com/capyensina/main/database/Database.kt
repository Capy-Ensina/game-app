package br.com.capyensina.main.database

import br.com.capyensina.main.Main
import com.badlogic.gdx.utils.Json
import com.badlogic.gdx.utils.SerializationException
import ktx.json.JsonSerializer
import ktx.json.fromJson
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

class Database(main: Main) {
    var users: Array<User>


    init {
        //sendGet()
        users = getDatabase()
        println(users)
    }

    fun sendGet() {
        val url = URL("https://www.google.com/")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            val reader: BufferedReader = inputStream.bufferedReader()
            var line: String? = reader.readLine()
            while (line != null) {
                println(line)
                line = reader.readLine()
            }
            reader.close()
        }
    }

    fun getDatabase() : Array<User> {
        val url = URL("https://capyensina-api-production.up.railway.app")
        val urlConnection = url.openConnection() as HttpURLConnection
        val content = urlConnection.inputStream.bufferedReader().readText()

        val json = Json()
        var response: Array<User> = emptyArray()
        try {
            response = arrayOf(json.fromJson(User::class.java ,content))
        } catch (e: SerializationException){
            println(e)
        }

        return response
    }
}
