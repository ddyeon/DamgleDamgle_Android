package com.mashup.damgledamgle.presentation.feature.home.bottomsheet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.ui.theme.Black
import com.mashup.damgledamgle.ui.theme.Gray1000

@Composable
fun BottomSheetCollapsedContent(
        modifier: Modifier = Modifier,
        alpha: Float
) {
    Spacer(modifier = Modifier.height(20.dp))
    Text(
            modifier = Modifier.alpha(alpha),
            color = Gray1000,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.home_bottomsheet_leave_my_story)
    )
}
