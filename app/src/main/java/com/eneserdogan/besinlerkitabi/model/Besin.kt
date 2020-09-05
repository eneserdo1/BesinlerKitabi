package com.eneserdogan.besinlerkitabi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity//Modeli SqlLite'a entegre etmek için
data class Besin(
    @ColumnInfo(name="isim")//SqlLite'da kolon ismi verdik.Eğer hata verirse burdaki isimle alttaki val değerini aynı yap.
    @SerializedName("isim")
    val besiIsim: String?,

    @ColumnInfo(name = "kalori")
    @SerializedName("kalori")
    val besinKalori: String?,

    @ColumnInfo(name="karbonhidrat")
    @SerializedName("karbonhidrat")
    val besinKarbonhidrat: String?,

    @ColumnInfo(name="protein")
    @SerializedName("protein")
    val besinProtein: String?,

    @ColumnInfo(name = "yag")
    @SerializedName("yag")
    val besinYag: String?,

    @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    val besinGorsel: String?
) {

    @PrimaryKey(autoGenerate = true)//Primarykey otomatik atadık
    var uuid:Int=0
}