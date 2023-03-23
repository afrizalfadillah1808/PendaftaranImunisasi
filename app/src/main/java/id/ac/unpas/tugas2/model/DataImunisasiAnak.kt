package id.ac.unpas.tugas2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class DataImunisasiAnak(
    @PrimaryKey val id: String,
    val nama: String,
    val Umur: String,
    val berat: String,
    val tinggi: String
)
