package by.atmm.kotlin.topics.telegram

fun main() {
//    val openAiClient = OpenAI(
//        OpenAIConfig(
//            token = "YOUR_OPENAI_TOKEN",
//            logLevel = LogLevel.Info,
//        )
//    )
//
//    val bot = bot {
//        token = "YOUR_API_KEY"
//        dispatch {
//            message {
//
//                update.message?.text?.let { message ->
//                    val chatId = ChatId.fromId(update.message!!.chat.id)
//
//                    val result = bot.sendMessage(
//                        chatId = chatId,
//                        text = "Processing..."
//                    )
//
//                    val messageId = result.get().messageId
//
//                    val chatCompletionRequest = ChatCompletionRequest(
//                        model = ModelId("gpt-3.5-turbo"),
//                        messages = listOf(
//                            ChatMessage(
//                                role = ChatRole.User,
//                                content = message
//                            )
//                        )
//                    )
//
//
//                    runBlocking {
//                        val response = openAiClient.chatCompletion(chatCompletionRequest)
//                        val responseText = response.choices.firstOrNull().message?.content ?: "A completion error occurred!"
//                        bot.editMessageText(
//                            chatId = chatId,
//                            messageId = messageId,
//                            text = responseText
//                        )
//                    }
//                }
//
//            }
//        }
//    }
//    bot.startPolling()
}
