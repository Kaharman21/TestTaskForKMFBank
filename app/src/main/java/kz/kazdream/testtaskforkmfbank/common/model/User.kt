package kz.kazdream.testtaskforkmfbank.common.model

//@Serializable
data class User (
    val username: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
    val phone: String,
    val userStatus: Int
)