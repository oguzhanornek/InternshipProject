package com.oguzornek.internshipproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oguzornek.internshipproject.R
import kotlinx.android.synthetic.main.bottom_sheet_dialog.view.*

class BottomSheetFragment : BottomSheetDialogFragment() {
    val args : BottomSheetFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog,container,false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.post_button.setOnClickListener(){
            val action2 = BottomSheetFragmentDirections.actionBottomSheetFragmentToPostFragment(args.userId)
            NavHostFragment.findNavController(this).navigate(action2)
        }

        view.photos_button.setOnClickListener(){
            val action3 = BottomSheetFragmentDirections.actionBottomSheetFragmentToAlbumFragment(args.userId)
            NavHostFragment.findNavController(this).navigate(action3)
        }

    }
}