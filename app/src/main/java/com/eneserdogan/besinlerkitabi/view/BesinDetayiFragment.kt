package com.eneserdogan.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eneserdogan.besinlerkitabi.R
import com.eneserdogan.besinlerkitabi.databinding.FragmentBesinDetayiBinding
import com.eneserdogan.besinlerkitabi.util.gorselIndir
import com.eneserdogan.besinlerkitabi.util.placeHolderYap
import com.eneserdogan.besinlerkitabi.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {

    private var besinId=0
    private lateinit var viewModel:BesinDetayiViewModel
    private lateinit var databinding : FragmentBesinDetayiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding=DataBindingUtil.inflate(inflater,R.layout.fragment_besin_detayi,container,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            besinId= BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)


        }

        viewModel=ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiAl(besinId)
        observeLiveData()

       /* arguments?.let {
            besinId=
                BesinDetayiFragmentArgs.fromBundle(
                    it
                ).besinId
            println(besinId)

        }*/
    }

    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer {besin ->
            besin?.let {
                databinding.secilenBesin=it


//                besinIsim.text=it.besiIsim
//                besinKalori.text=it.besinKalori
//                besinKarbonhidrat.text=it.besinKarbonhidrat
//                besinProtein.text=it.besinProtein
//                besinYag.text=it.besinYag
//                context?.let {
//                    besinImage.gorselIndir(besin.besinGorsel, placeHolderYap(it))
//
//                }
            }
        })
    }

}
