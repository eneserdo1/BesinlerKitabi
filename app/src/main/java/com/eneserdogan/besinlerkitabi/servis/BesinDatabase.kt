package com.eneserdogan.besinlerkitabi.servis

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eneserdogan.besinlerkitabi.model.Besin

@Database(entities = arrayOf(Besin::class),version = 1)
abstract class BesinDatabase : RoomDatabase() {

    abstract fun besinDao():BesinDAO


    //Singleton-Tek bir obje oluşturabileceğimiz sınıflardır
    companion object{
        @Volatile private var instance :BesinDatabase?=null//BesinDatabase instance oluşmuş mu o bakılıyor

        private val lock=Any()
        //veritaabnı çağrılırken invoke çağrılacak
        operator fun invoke(context: Context) = instance ?: synchronized(lock){//instance varsa  döndür,yoksa synchronized işlemleri yürüt
            instance ?: databaseOlustur(context).also {//Also bunu yap,şunu da yap demek
                instance=it

            }

        }


        private fun databaseOlustur(context: Context)=Room.databaseBuilder(
            context.applicationContext
            ,BesinDatabase::class.java,"besinDatabase").build()
    }





}