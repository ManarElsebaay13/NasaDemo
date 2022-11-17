package com.manarelsebaay.nasademo.db.local

import androidx.room.TypeConverter
import com.manarelsebaay.nasademo.db.model.Camera
import com.manarelsebaay.nasademo.db.model.Rover


class DBConverters {

    //Camera
    @TypeConverter
    fun fromSource(source: Camera): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Camera{
        return Camera(name,name,name,name)
    }


    //rover
    @TypeConverter
    fun roverfromSource(source: Rover): String{
        return source.name
    }

    @TypeConverter
    fun rovertoSource(name:String):Rover{
        return Rover(name,name,name,name,name)
    }

}