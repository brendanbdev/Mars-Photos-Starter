package com.example.marsphotos.network
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

/*
In this task, you use the kotlinx.serialization library, to parse the JSON
response from the web service into useful Kotlin objects that represent Mars
photos. You change the app so that instead of displaying the raw JSON, the app
displays the number of Mars photos returned.
*/
@Serializable
data class MarsPhoto(
    val id: String,
    val img_src: String
)

@SerialName(value = "img_src")
val imgSrc: String = ""