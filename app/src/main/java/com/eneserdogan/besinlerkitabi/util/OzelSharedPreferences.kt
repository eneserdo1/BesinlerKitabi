package com.eneserdogan.besinlerkitabi.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.concurrent.locks.Lock

class OzelSharedPreferences {

    companion object{

        private val ZAMAN="zaman"
        private var sharedPreferences : SharedPreferences?=null

        @Volatile private var instance: OzelSharedPreferences?=null
        var lock=Any()
        operator fun invoke(context: Context) :OzelSharedPreferences= instance?: synchronized(lock){
            instance ?: ozelSharedPreferencesYap(context).also {
                instance=it
            }


        }

        private fun ozelSharedPreferencesYap(context: Context) :OzelSharedPreferences{
            sharedPreferences=androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPreferences()

        }
    }

    fun zamaniKaydet(zaman:Long){
        sharedPreferences?.edit(commit=true){
            putLong(ZAMAN,zaman)

        }

    }

    fun zamaniAl()= sharedPreferences?.getLong(ZAMAN,0)
}