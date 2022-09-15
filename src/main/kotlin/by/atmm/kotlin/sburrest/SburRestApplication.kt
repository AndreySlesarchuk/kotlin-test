package by.atmm.kotlin.topics.classes.database

import by.atmm.kotlin.sburrest.Droid
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean


@SpringBootApplication
@ConfigurationPropertiesScan
open class SburRestApplication {
    @Bean
    @ConfigurationProperties(prefix = "droid")
    open fun createDroid() = Droid()

}







