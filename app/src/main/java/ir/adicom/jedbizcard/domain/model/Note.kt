package ir.adicom.jedbizcard.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    var color: ColorModel?,

    @ColumnInfo(name = "noteTitle")
    var noteTitle: String?,

    @ColumnInfo(name = "noteBody")
    var noteBody: String?,

    @ColumnInfo(name = "isChecked")
    var isChecked: Boolean = false
)