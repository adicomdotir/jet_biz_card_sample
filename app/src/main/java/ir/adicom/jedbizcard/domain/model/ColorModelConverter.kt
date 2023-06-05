package ir.adicom.jedbizcard.domain.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class ColorModelConverter {
    @TypeConverter
    fun fromColorModel(colorModel: ColorModel?): String? {
        return Gson().toJson(colorModel)
    }

    @TypeConverter
    fun toColorModel(colorModelString: String?): ColorModel? {
        return Gson().fromJson(colorModelString, ColorModel::class.java)
    }
}