package com.oguzornek.internshipproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.databinding.BottomSheetDialogBinding


class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : BottomSheetDialogBinding
    val args : BottomSheetFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.bottom_sheet_dialog,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postButton.setOnClickListener(){
            val action2 = BottomSheetFragmentDirections.actionBottomSheetFragmentToPostFragment(args.userId)
            NavHostFragment.findNavController(this).navigate(action2)
        }

        binding.photosButton.setOnClickListener(){
            val action3 = BottomSheetFragmentDirections.actionBottomSheetFragmentToAlbumFragment(args.userId)
            NavHostFragment.findNavController(this).navigate(action3)
        }

    }
}