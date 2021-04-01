package com.oguzornek.internshipproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.adapter.UserListRecyclerAdapter
import com.oguzornek.internshipproject.databinding.FragmentUsersBinding
import com.oguzornek.internshipproject.viewmodel.UserListViewModel


class UsersFragment : Fragment() {
    private lateinit var binding : FragmentUsersBinding

    private lateinit var usersviewModel : UserListViewModel
    private val recyclerUserAdapter = UserListRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_users,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersviewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        usersviewModel.getUserData()

        binding.userListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.userListRecyclerView.adapter = recyclerUserAdapter
        observeLiveData()


    }

    fun observeLiveData(){
        usersviewModel.users.observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerUserAdapter.userList = it
                recyclerUserAdapter.notifyDataSetChanged()


            }
        })
    }



}