package com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.R
import com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.databinding.MainFragmentBinding
import com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.bottom_sheet.BottomSheetDialog

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainFragmentBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            button.setOnClickListener {
                BottomSheetDialog().show(childFragmentManager, null)
            }
        }
    }
}