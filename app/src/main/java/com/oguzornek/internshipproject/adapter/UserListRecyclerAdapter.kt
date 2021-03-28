package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.model.Users
import com.oguzornek.internshipproject.view.UsersFragmentDirections
import kotlinx.android.synthetic.main.user_recycler_row.view.*


class UserListRecyclerAdapter(var kullaniciListesi: List<Users>) : RecyclerView.Adapter<UserListRecyclerAdapter.KullaniciViewHolder>() {

    class KullaniciViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(item: Users) {
            itemView.userNameText.text = item.userName
            itemView.nameText.text = item.name
            itemView.mailText.text = item.userMail

            itemView.setOnClickListener {
                val userId: Int?
                userId = item.userId
                val action = UsersFragmentDirections.actionKullanicilarFragmentToBottomSheetFragment(userId!!)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KullaniciViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_recycler_row, parent, false)
        return KullaniciViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kullaniciListesi.size
    }

    override fun onBindViewHolder(holder: KullaniciViewHolder, position: Int) {
        holder.bind(kullaniciListesi.get(position))
    }
}