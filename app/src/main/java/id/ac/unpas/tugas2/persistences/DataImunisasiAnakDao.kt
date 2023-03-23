package id.ac.unpas.tugas2.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.tugas2.model.DataImunisasiAnak

@Dao
interface DataImunisasiAnakDao {
    @Query("SELECT * FROM DataImunisasiAnak")
    fun loadAll(): LiveData<List<DataImunisasiAnak>>

    @Query("SELECT * FROM DataImunisasiAnak WHERE id = :id")
    fun find(id: String): DataImunisasiAnak?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataImunisasiAnak)

    @Delete
    fun delete(item: DataImunisasiAnak)
}