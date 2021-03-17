package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.model.Kullanicilar
import com.oguzornek.internshipproject.view.KullanicilarFragmentDirections
import kotlinx.android.synthetic.main.kullanici_recyler_row.view.*


class KullaniciListesiRecyclerAdapter(var kullaniciListesi: List<Kullanicilar>) : RecyclerView.Adapter<KullaniciListesiRecyclerAdapter.KullaniciViewHolder>() {

    class KullaniciViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(item: Kullanicilar) {
            itemView.kullaniciAdiText.text = item.kullaniciAdi
            itemView.isimText.text = item.isim
            itemView.mailText.text = item.kullaniciMail

            itemView.setOnClickListener {
                val userId: Int?
                userId = item.userId
                val action = KullanicilarFragmentDirections.actionKullanicilarFragmentToUserChooseFragment(userId!!)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KullaniciViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kullanici_recyler_row, parent, false)
        return KullaniciViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kullaniciListesi.size
    }

    override fun onBindViewHolder(holder: KullaniciViewHolder, position: Int) {
        holder.bind(kullaniciListesi.get(position))
    }
}