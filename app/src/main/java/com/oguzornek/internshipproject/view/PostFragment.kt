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
import com.oguzornek.internshipproject.adapter.PostRecyclerAdapter
import com.oguzornek.internshipproject.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getPost(args.userId)

        post_recyclerView.layoutManager = LinearLayoutManager(context)
        post_recyclerView.adapter = recylerPostAdapter

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