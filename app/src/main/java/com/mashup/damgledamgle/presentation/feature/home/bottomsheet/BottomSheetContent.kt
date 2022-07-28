package com.mashup.damgledamgle.presentation.feature.home.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.mashup.damgledamgle.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent(bottomSheetScaffoldState: BottomSheetScaffoldState) {
    Box(
            modifier = Modifier
                    .background(
                            brush = Brush.verticalGradient(
                                    0.15f to Grey500,
                                    0.3f to Orange400,
                                    0.38f to Orange600,
                                    0.7f to Orange600,
                                    0.76f to Orange400,
                                    0.85f to Grey500,
                            )
                    )
                    .fillMaxWidth()
                    .fillMaxHeight()
    ) {
        Column(
                modifier = Modifier
                        .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                    modifier = Modifier
                            .padding(top = 16.dp)
                            .width(64.dp)
                            .clip(RoundedCornerShape(2.dp)),
                    color = Gray600,
                    thickness = 5.dp,
            )

            val bottomSheetSlide = getBottomSheetSlide(bottomSheetScaffoldState.bottomSheetState)

            if (bottomSheetSlide >= BOTTOM_SHEET_SLIDE_THRESHOLD) {
                BottomSheetCollapsedContent(alpha = (bottomSheetSlide - BOTTOM_SHEET_SLIDE_THRESHOLD) / (1 + ADDITIONAL_FLOAT - BOTTOM_SHEET_SLIDE_THRESHOLD))
            } else {
                BottomSheetExpandedContent(alpha = 1 - (bottomSheetSlide / BOTTOM_SHEET_SLIDE_THRESHOLD + ADDITIONAL_FLOAT))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun getBottomSheetSlide(state: BottomSheetState): Float {
    val fraction = state.progress.fraction
    return when {
        state.currentValue == state.targetValue -> {
            if (state.currentValue == BottomSheetValue.Collapsed) 1f else 0f
        }
        state.isCollapsed -> 1 - fraction
        else -> fraction
    }
}

const val BOTTOM_SHEET_SLIDE_THRESHOLD = 0.7f
const val ADDITIONAL_FLOAT = 0.001f
