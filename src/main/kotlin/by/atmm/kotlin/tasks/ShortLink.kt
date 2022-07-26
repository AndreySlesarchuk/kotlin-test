import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import java.time.Duration


/**
 *  @author Andrey Slesarchuk
 *  @date 2022-07-06
 *
 */

class ShortLink {
    fun getShortLink(uriStr: String, map: Map<String, String>?): String {
        val responseMap: MutableMap<*, *>? = try {
            val objectMapper = ObjectMapper()

            val requestBody: String = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map)

            val request = HttpRequest.newBuilder()
                .uri(URI.create(uriStr))
                .timeout(Duration.ofSeconds(3))
                .header("Content-Type", "application/json")
                .header(
                    "x-goo-api-token",
                    "qMMJkTBBbMLUi5IAgYLm8jbF2y8iD2nULA0xc1UcQ6oxtDL4htbJTeR56JWm"
                )
                .POST(BodyPublishers.ofString(requestBody))
                .build()

            val response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
            objectMapper.readValue(response.body(), MutableMap::class.java)
        } catch (e: Exception) {
            println("Short link: data to work is not correct $e")
            null
        }
        return if (responseMap == null || responseMap["message"] != "Link successfully created") {
            ""
        } else {
            responseMap["short_url"].toString()
        }
    }

    companion object {
        const val URI_STRING = "https://goo.su/api/links/create"

        @JvmStatic
        fun main(args: Array<String>) {

            val linkStr = "https://ryanharrison.co.uk/2018/06/15/make-http-requests-kotlin.html"
            val sl = ShortLink()
            val jsonData: MutableMap<String, String> = HashMap()
            jsonData["url"] = linkStr
            val shortLink = sl.getShortLink(URI_STRING, jsonData)
            println("Short link: $shortLink")//log.fine(shortLink)

        }
    }
}
