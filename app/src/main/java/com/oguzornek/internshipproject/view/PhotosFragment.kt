package com.oguzornek.internshipproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.adapter.PhotosRecyclerAdapter
import com.oguzornek.internshipproject.databinding.FragmentPhotosBinding
import com.oguzornek.internshipproject.viewmodel.PhotosViewModel


class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_photos,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        photosViewModel.getPhotos(args.photoId)

        binding.albumRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.albumRecyclerView.adapter = recylerAdapter

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