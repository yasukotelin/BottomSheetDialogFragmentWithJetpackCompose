package com.github.yasukotelin.bottomnavigationfragmentwithjetpackcompose.ui.bottom_sheet.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yasukotelin.bottomnavigationfragmentwithjetpackcompose.ui.theme.Black
import com.github.yasukotelin.bottomnavigationfragmentwithjetpackcompose.ui.theme.Purple200
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

private val items = (1..8).map {
    "item $it"
}

@Composable
fun BottomSheetDialogScreen(
    onScrollState: (isTop: Boolean) -> Unit,
) {
    val listState = rememberLazyListState()

    Surface(color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            LazyColumn(state = listState, horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Knob(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp))
                }
                items(items) {
                    ItemButton(it)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.firstOrNull()?.offset }
            .map { it == 0 }
            .distinctUntilChanged()
            .collect {
                onScrollState(it)
            }
    }
}

@Composable
@Preview
fun PreviewBottomSheetDialogScreen() {
    BottomSheetDialogScreen({})
}

@Composable
fun Knob(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(30.dp)
            .height(3.dp)
            .background(color = Color(0xFFC4C4C4), shape = RoundedCornerShape(size = 12.dp))
    )
}

@Composable
@Preview
fun PreviewKnob() {
    Knob()
}

@Composable
fun ItemButton(text: String) {
    OutlinedButton(modifier = Modifier
        .fillMaxWidth()
        .height(37.dp)
        .padding(horizontal = 26.dp),
        border = BorderStroke(width = 1.dp, color = Purple200),
        onClick = { /*TODO*/ }) {
        Text(text, fontSize = 14.sp, color = Black)
    }
}

@Composable
@Preview
fun PreviewItemButton() {
    ItemButton("Item1")
}