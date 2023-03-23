package id.ac.unpas.tugas2.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.tugas2.model.DataImunisasiAnak

@Database(entities = [DataImunisasiAnak::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataImunisasiAnakDao(): DataImunisasiAnakDao
}