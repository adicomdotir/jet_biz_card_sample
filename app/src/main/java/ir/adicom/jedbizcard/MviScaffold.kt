package ir.adicom.jedbizcard

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface State

interface Action

interface Reducer<S : State, A : Action> {
    fun reduce(state: S, action: A): S
}

open class MviBasicViewModel<S : State, A : Action>(
    private val reducer: Reducer<S, A>,
    stateInit: S
) : ViewModel() {
    private val actionFlow = MutableSharedFlow<A>(extraBufferCapacity = 128)

    var state: S by mutableStateOf(stateInit)
        private set

    init {
        viewModelScope.launch {
            actionFlow.collect { action ->
                state = reducer.reduce(state, action)
            }
        }
    }

    fun emit(action: A) {
        val success = actionFlow.tryEmit(action)
        if (success) {
            Log.d("???", "success $action")
        } else {
            Log.d("???", "MVI action buffer is overflow")
        }
    }
}