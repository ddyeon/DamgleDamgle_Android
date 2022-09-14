package com.mashup.damgledamgle.presentation.feature.leave_story

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mashup.damgledamgle.R

@Composable
fun LeaveStoryError(onClickBottomButton: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            GNB(
                rightContent = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = null,
                        modifier = Modifier
                            .width(24.dp)
                            .offset(x = (-16).dp)
                            .clickable {
                                onClickBottomButton()
                            }
                    )
                }
            )
            Spacer(modifier = Modifier.height(28.dp))
            LeaveStoryInner(
                titleRes = R.string.leave_story_now_leaving_a_story_error,
                subscriptionRes = R.string.leave_story_now_leaving_a_story_error_description,
                lottieRes = R.raw.write_fail
            )
        }
        LeaveStoryBottomButton("다시 담글 남기러 가기") { onClickBottomButton() }
    }
}

