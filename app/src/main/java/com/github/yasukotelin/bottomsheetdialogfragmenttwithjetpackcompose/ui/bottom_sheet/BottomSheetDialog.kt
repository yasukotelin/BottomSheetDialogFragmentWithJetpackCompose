package com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
import com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.bottom_sheet.compose.BottomSheetDialogScreen
import com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.theme.SampleTheme
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog : BottomSheetDialogFragment() {

    private val bottomSheetDialogBehavior: BottomSheetBehavior<FrameLayout>?
        get() = (dialog as? com.google.android.material.bottomsheet.BottomSheetDialog)?.behavior

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                SampleTheme {
                    BottomSheetDialogScreen(
                        onScrollState = { isTop ->
                            bottomSheetDialogBehavior?.isDraggable = isTop
                        }
                    )
                }
            }
        }
    }
}