package com.eneserdogan.besinlerkitabi.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eneserdogan.besinlerkitabi.model.Besin
import com.eneserdogan.besinlerkitabi.servis.BesinDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BesinDetayiViewModel(application: Application) : BaseViewModel(application) {
    val besinLiveData=MutableLiveData<Besin>()

    fun roomVerisiAl(uuid:Int){
        launch {
            val dao=BesinDatabase(getApplication()).besinDao()
            val besin=dao.getBesin(uuid)
            besinLiveData.value=besin
        }

    }
}