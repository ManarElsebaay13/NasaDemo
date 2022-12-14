package com.manarelsebaay.nasademo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manarelsebaay.nasademo.data.remote.dto.Photo


@Dao
interface NasaDAO {

    @Query("SELECT*FROM NasaEntity")
    fun getAllitems (): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: Photo)

}