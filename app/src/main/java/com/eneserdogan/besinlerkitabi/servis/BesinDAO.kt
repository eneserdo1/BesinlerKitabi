package com.eneserdogan.besinlerkitabi.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eneserdogan.besinlerkitabi.model.Besin

@Dao
interface BesinDAO {

    //Data access object
    @Insert               //Birden fazla koyulabiliyor
    suspend fun insertAll(vararg besin:Besin) :List<Long>

    //Insert->Room,insert,into
    //suspend->coroutine scope
    //vararg ->birden fazla besin alabiliyor
    //List<Long> ->long,id'ler

    @Query("SELECT * FROM besin")
    suspend fun getAllBesin():List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId ")
    suspend fun getBesin(besinId:Int):Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()
}