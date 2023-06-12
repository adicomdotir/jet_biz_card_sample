package ir.adicom.jedbizcard.features.authentication.domain.models

data class User(
    val id: Long,
    val username: String,
    val password: String
)
