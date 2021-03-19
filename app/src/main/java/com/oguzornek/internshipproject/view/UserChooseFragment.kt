package com.oguzornek.internshipproject.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.oguzornek.internshipproject.R
import kotlinx.android.synthetic.main.fragment_user_choose.view.*


class UserChooseFragment : Fragment() {
    val args : UserChooseFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v("UserIdLog",args.userId.toString())

        view.postButton.setOnClickListener(){
            val action2 = UserChooseFragmentDirections.actionUserChooseFragmentToPostFragment()
            Navigation.findNavController(it).navigate(action2)
        }

        view.albumsbutton.setOnClickListener(){
            val action3 = UserChooseFragmentDirections.actionUserChooseFragmentToAlbumFragment()
            Navigation.findNavController(it).navigate(action3)
        }

    }


}