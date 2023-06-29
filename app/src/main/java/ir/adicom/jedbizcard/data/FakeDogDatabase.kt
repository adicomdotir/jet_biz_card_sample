package ir.adicom.jedbizcard.data

import ir.adicom.jedbizcard.model.Player
import ir.adicom.jedbizcard.model.PositionType

object FakePlayerDatabase {
    val playerList = listOf<Player>(
        Player(1, "Ali", "Pinto", 17, 85, 91, 70, PositionType.GK),
        Player(2, "Ali", "Coppola", 17, 85, 91, 70, PositionType.RB),
        Player(3, "Ali", "Wyatt", 17, 85, 91, 70, PositionType.LB),
        Player(4, "Ali", "Mancini", 17, 85, 91, 70, PositionType.CM),
        Player(5, "Ali", "West", 17, 85, 91, 70, PositionType.CD),
        Player(6, "Ali", "Costa", 17, 85, 91, 70, PositionType.CAM),
        Player(7, "Ali", "Colombo", 17, 85, 91, 70, PositionType.CF),
        Player(8, "Cristiano", "Ronaldo", 17, 85, 91, 70, PositionType.CF),
    )
}