package com.oguzornek.internshipproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.adapter.PhotosRecyclerAdapter
import com.oguzornek.internshipproject.viewmodel.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_album.*

class PhotosFragment : Fragment() {
    val args : PhotosFragmentArgs by navArgs()
    private lateinit var photosViewModel: PhotosViewModel
    private val recylerAdapter = PhotosRecyclerAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        photosViewModel.getPhotos(args.photoId)

        album_recyclerView.layoutManager = LinearLayoutManager(context)
        album_recyclerView.adapter = recylerAdapter

        observeLiveData()
    }

    fun observeLiveData(){
        photosViewModel.photos.observe(viewLifecycleOwner){
            it?.let {
                recylerAdapter.photoList = it
                recylerAdapter.notifyDataSetChanged()

            }
        }

    }

}