package com.oguzornek.internshipproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.adapter.KullaniciListesiRecyclerAdapter
import com.oguzornek.internshipproject.viewmodel.KullaniciListesiViewModel
import kotlinx.android.synthetic.main.fragment_kullanicilar.*


class KullanicilarFragment : Fragment() {

    private lateinit var kullanicilarviewModel : KullaniciListesiViewModel
    private val recyclerKullaniciadapter = KullaniciListesiRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kullanicilar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kullanicilarviewModel = ViewModelProviders.of(this).get(KullaniciListesiViewModel::class.java)
        kullanicilarviewModel.verileriCek()

        kullaniciListesi_RecyclerView.layoutManager = LinearLayoutManager(context)
        kullaniciListesi_RecyclerView.adapter = recyclerKullaniciadapter
        observeLiveData()


    }

    fun observeLiveData(){
        kullanicilarviewModel.kullancilar.observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerKullaniciadapter.kullaniciListesi = it
                recyclerKullaniciadapter.notifyDataSetChanged()


            }
        })
    }



}