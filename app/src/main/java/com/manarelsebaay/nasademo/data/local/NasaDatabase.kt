package com.manarelsebaay.nasademo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manarelsebaay.nasademo.data.remote.dto.Photo


@Database(
    entities = [Photo::class],
    version = 1
)
@TypeConverters ( DBConverters::class)

abstract class NasaDatabase: RoomDatabase() {
    abstract fun getItemsDao(): NasaDAO

    companion object{

        //GET DB INSTANCE
        @Volatile
        private var instance: NasaDatabase? = null


        //Syncronize DB calling

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }


        //  CREATE DB
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NasaDatabase::class.java,
                "nasa_db.db"
            ).build() }


}