package ir.adicom.jedbizcard

class FavoriteViewModel(
    reducer: FavoriteReducer = FavoriteReducer()
) : MviBasicViewModel<FavoriteState, FavoriteAction>(
    reducer = reducer,
    stateInit = FavoriteState(false)
) {
    fun onFavorite() {
        emit(FavoriteAction.Favorite)
    }

    fun onUnFavorite() {
        emit(FavoriteAction.UnFavorite)
    }
}