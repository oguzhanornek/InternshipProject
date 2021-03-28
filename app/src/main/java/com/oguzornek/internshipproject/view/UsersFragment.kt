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
import com.oguzornek.internshipproject.adapter.UserListRecyclerAdapter
import com.oguzornek.internshipproject.viewmodel.UserListViewModel
import kotlinx.android.synthetic.main.fragment_users.*


class UsersFragment : Fragment() {

    private lateinit var kullanicilarviewModel : UserListViewModel
    private val recyclerKullaniciadapter = UserListRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kullanicilarviewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        kullanicilarviewModel.verileriCek()

        userList_RecyclerView.layoutManager = LinearLayoutManager(context)
        userList_RecyclerView.adapter = recyclerKullaniciadapter
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