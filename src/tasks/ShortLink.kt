import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse


/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-06
 */

fun main() {
    // get a string from the input string where will be letters with it's count repeating
    // linkStr: https://ryanharrison.co.uk/2018/06/15/make-http-requests-kotlin.html
    // result: A6B4C3D2EF8

    val link = "https://ryanharrison.co.uk/2018/06/15/make-http-requests-kotlin.html"

    println(shortLink(link))
}

fun shortLink(linkStr: String): String {
    val json = mapOf("url" to linkStr)

    val objectMapper = ObjectMapper()
    val requestBody: String = objectMapper
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(map)



    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://goo.su/api/links/create"))
        .header("Content-Type", "application/json")
        .header("x-goo-api-token", "qMMJkTBBbMLUi5IAgYLm8jbF2y8iD2nULA0xc1UcQ6oxtDL4htbJTeR56JWm")
        .POST(BodyPublishers.ofString(json.toString()))
        .build();
    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
}