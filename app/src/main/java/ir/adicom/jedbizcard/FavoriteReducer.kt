package ir.adicom.jedbizcard

class FavoriteReducer: Reducer<FavoriteState, FavoriteAction> {
    override fun reduce(state: FavoriteState, action: FavoriteAction): FavoriteState {
        return when(action) {
            FavoriteAction.Favorite -> state.copy(favorite = true)
            FavoriteAction.UnFavorite -> state.copy(favorite = false)
        }
    }
}