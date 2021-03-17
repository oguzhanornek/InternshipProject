package com.oguzornek.internshipproject.adapter

import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.model.Kullanicilar
import com.oguzornek.internshipproject.view.KullanicilarFragment
import com.oguzornek.internshipproject.view.KullanicilarFragmentDirections
import kotlinx.android.synthetic.main.kullanici_recyler_row.view.*


class KullaniciListesiRecyclerAdapter(var kullaniciListesi : List<Kullanicilar>) : RecyclerView.Adapter<KullaniciListesiRecyclerAdapter.KullaniciViewHolder>() {



    class KullaniciViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KullaniciViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kullanici_recyler_row,parent,false)
        return KullaniciViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kullaniciListesi.size
    }

    override fun onBindViewHolder(holder: KullaniciViewHolder, position: Int) {

        val userId = kullaniciListesi.get(position).userId
        holder.itemView.kullaniciAdiText.text = kullaniciListesi.get(position).kullaniciAdi
        holder.itemView.isimText.text = kullaniciListesi.get(position).isim
        holder.itemView.mailText.text = kullaniciListesi.get(position).kullaniciMail


        holder.itemView.setOnClickListener(){

            val action = KullanicilarFragmentDirections.actionKullanicilarFragmentToUserChooseFragment()
            Navigation.findNavController(it).navigate(action)


        }
    }
}