package br.com.capyensina.main.database

import br.com.capyensina.main.Main
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Net.HttpMethods
import com.badlogic.gdx.Net.HttpResponseListener
import com.badlogic.gdx.net.HttpRequestBuilder
import com.badlogic.gdx.utils.Json
import com.badlogic.gdx.utils.SerializationException
import ktx.async.httpRequest
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

/* Nota Malcoln 02/12 11:58
 * A classe não está sendo iniciada na Main, se alterar algo nela, atualiza lá
 * e adiciona o que precisar no PlayerScoreManager
 */

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

    fun sendPost() {
        var httpResponseListener: HttpResponseListener
        var requestBuilder = HttpRequestBuilder()
        var request = requestBuilder
            .newRequest()
            .method(HttpMethods.POST)
            .url("web-api-capyensina.up.railway.app")
            .build()
        //Gdx.net.sendHttpRequest(request, httpResponseListener)

    }

    fun getDatabase() : Array<User> {
        // url para acessar o banco de dados
        val url = URL("https://capyensina-api-production.up.railway.app/ranking")
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
