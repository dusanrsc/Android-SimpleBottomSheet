package com.infinitysoftware.simplebottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.infinitysoftware.simplebottomsheet.ui.theme.*
import com.infinitysoftware.simplebottomsheet.ui.theme.SimpleBottomSheetTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleBottomSheetTheme {

                val sheetState = rememberStandardBottomSheetState()
                val scaffoldState = rememberBottomSheetScaffoldState(sheetState)
                val scope = rememberCoroutineScope()

                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Simple Bottom Sheet", fontSize = 30.sp)
                        }
                    },
                    sheetContentColor = SimpleBottomSheetContentColor,
                    sheetContainerColor = SimpleBottomSheetContainerColor,
                    sheetPeekHeight = 0.dp
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().background(MyTomatoRed),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            scope.launch {
                                if (sheetState.currentValue == SheetValue.PartiallyExpanded) {
                                    sheetState.expand()
                                } else {
                                    sheetState.partialExpand()
                                }
                            }
                        }) {
                            Text(text = "Toggle Simple Bottom Sheet")
                        }
                    }
                }
            }
        }
    }
}