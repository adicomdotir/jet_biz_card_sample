package ir.adicom.jedbizcard.model

data class Player(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val min_potential: Int,
    val max_potential: Int,
    val overall: Int,
    val position: PositionType,
)

enum class PositionType {
    GK, RB, LB, CD, RWB, LWB, RM, LM, CDM, CM, CAM, RW, LW, CF, ST
}