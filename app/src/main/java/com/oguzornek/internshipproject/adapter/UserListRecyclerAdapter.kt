package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.databinding.UserRecyclerRowBinding
import com.oguzornek.internshipproject.model.Users
import com.oguzornek.internshipproject.view.UsersFragmentDirections



class UserListRecyclerAdapter(var userList: List<Users>) : RecyclerView.Adapter<UserListRecyclerAdapter.UserViewHolder>() {

    class UserViewHolder(val view: UserRecyclerRowBinding) : RecyclerView.ViewHolder(view.root) {


        fun bind(item: Users) {
            view.userNameText.text = item.userName
            view.nameText.text = item.name
            view.mailText.text = item.userMail

            itemView.setOnClickListener {
                val userId: Int?
                userId = item.userId
                val action = UsersFragmentDirections.actionKullanicilarFragmentToBottomSheetFragment(userId!!)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<UserRecyclerRowBinding>(inflater,R.layout.user_recycler_row,parent,false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList.get(position))
    }
}