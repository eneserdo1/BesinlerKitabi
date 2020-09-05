package com.eneserdogan.besinlerkitabi.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.eneserdogan.besinlerkitabi.R

/*
fun String.benimEklentim(parametre:String){
    println(parametre)
    buraya ulaşıp fonksiyonu çağırabiliyoruz

}*/

fun ImageView.gorselIndir(url:String?,placeHolder:CircularProgressDrawable){

    val options=RequestOptions().placeholder(placeHolder).error(R.mipmap.ic_launcher_round)//Options oluşturuldu
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)//Optionsı glide'a verdik
}

fun placeHolderYap(context:Context):CircularProgressDrawable{//Resim gelene kadar dönen drawable
    return CircularProgressDrawable(context).apply {
        strokeWidth =8f//Çizgi kalınlığı
        centerRadius=40f//Daire çapı
        start()
    }
}

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView,url: String?){
    view.gorselIndir(url, placeHolderYap(view.context))
}
