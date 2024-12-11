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
import com.badlogic.gdx.Net
import org.json.JSONObject

/* Nota Malcoln 02/12 11:58
 * A classe não está sendo iniciada na Main, se alterar algo nela, atualiza lá
 * e adiciona o que precisar no PlayerScoreManager
 */

class Database(main: Main) {

    init {
        //sendGet()
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

    fun sendPost1() {
        var httpResponseListener: HttpResponseListener
        var requestBuilder = HttpRequestBuilder()
        var request = requestBuilder
            .newRequest()
            .method(HttpMethods.POST)
            .url("web-api-capyensina.up.railway.app/ranking")
            .build()
        //Gdx.net.sendHttpRequest(request, httpResponseListener)

    }

    fun sendRankingData(name: String, points: Int, time: Float, onResponse: (String) -> Unit = {}, onError: (Throwable) -> Unit = {}) {
        // URL da API
        val url = "https://web-api-capyensina.up.railway.app/ranking"

        // Cria o objeto JSON com os dados a serem enviados
        val json = JSONObject()
        json.put("usuario", name)
        json.put("pontuacao", points)
        json.put("tempo", time.toDouble())
        json.put("minigame", "674fa3f04986613a96c7527c")

        // Constrói a requisição HTTP POST
        val httpRequest = HttpRequestBuilder()
            .newRequest()
            .method(Net.HttpMethods.POST)
            .url(url)
            .header("Content-Type", "application/json") // Define o tipo de conteúdo
            .content(json.toString()) // Converte o JSON para string

        // Envia a requisição usando o cliente HTTP do LibGDX
        Gdx.net.sendHttpRequest(httpRequest.build(), object : Net.HttpResponseListener {
            override fun handleHttpResponse(response: Net.HttpResponse) {
                val statusCode = response.status.statusCode
                if (statusCode == 200 || statusCode == 201) {
                    // Callback de sucesso com a resposta do servidor
                    onResponse(response.resultAsString)
                } else {
                    // Trata erros retornados pelo servidor
                    onError(Exception("Erro HTTP: $statusCode - ${response.resultAsString}"))
                }
            }

            override fun failed(t: Throwable) {
                // Callback de erro caso a requisição falhe
                onError(t)
            }

            override fun cancelled() {
                // Callback se a requisição for cancelada
                onError(Exception("Requisição cancelada"))
            }
        })
    }


}
