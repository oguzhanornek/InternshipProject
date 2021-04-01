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
import com.oguzornek.internshipproject.adapter.PostRecyclerAdapter
import com.oguzornek.internshipproject.databinding.FragmentPostBinding
import com.oguzornek.internshipproject.viewmodel.PostViewModel

class PostFragment : Fragment() {
    private lateinit var binding : FragmentPostBinding
    private val args : PostFragmentArgs by navArgs()
    private lateinit var postViewModel : PostViewModel
    private val recylerPostAdapter = PostRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_post,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getPost(args.userId)

        binding.postRecyclerView.layoutManager = LinearLayoutManager(context)
       binding.postRecyclerView.adapter = recylerPostAdapter

        observeLiveData()
    }

    fun observeLiveData(){
        postViewModel.postlar.observe(viewLifecycleOwner){
            it?.let {
                recylerPostAdapter.postList = it
                recylerPostAdapter.notifyDataSetChanged()

        }
    }

}
}