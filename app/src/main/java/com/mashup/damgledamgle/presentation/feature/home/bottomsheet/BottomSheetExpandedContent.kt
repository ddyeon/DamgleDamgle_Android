package com.mashup.damgledamgle.presentation.feature.home.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.ui.theme.*

@Composable
fun BottomSheetExpandedContent(
        modifier: Modifier = Modifier,
        alpha: Float,
) {
    Column(
            modifier = modifier
                    .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
                modifier = Modifier
                        .alpha(alpha)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            Text(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(R.string.home_bottomsheet_leave_story_on_this_place)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                    fontSize = 13.sp,
                    text = stringResource(R.string.home_bottomsheet_story_left_here_disappears_after_a_month)
            )
            Spacer(modifier = Modifier.height(32.dp))
            DamgleStoryBox(backGroundColor = Gray400, textColor = Gray900)
        }

        // TODO 글자수에 따라 Clickable, 디자인 변경
        Button(
                onClick = {},
                modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Gray600)
        ) {
            Text(
                    text = stringResource(id = R.string.home_bottomsheet_leave_a_story),
                    fontSize = 18.sp,
                    color = Gray400
            )
        }
    }
}
