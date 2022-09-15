package by.atmm.kotlin.sburrest

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "greeting")
@ConstructorBinding
class Greeting(
    val name: String,
    val coffee: String
)