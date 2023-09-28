package ir.adicom.jedbizcard

sealed interface FavoriteAction : Action {
    object Favorite : FavoriteAction

    object UnFavorite : FavoriteAction
}