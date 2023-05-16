package ir.adicom.jedbizcard.feature_users.presentation.edit

import androidx.compose.runtime.State

sealed class EditEvent {
    data class EnteredName(val value: String): EditEvent()
    data class EnteredLastName(val value: String): EditEvent()
    data class EnteredAge(val value: String): EditEvent()
    object InsertUser: EditEvent()
}
