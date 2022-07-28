package com.mashup.damgledamgle.presentation.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.ui.theme.Grey500
import com.mashup.damgledamgle.ui.theme.Orange500
import com.mashup.damgledamgle.ui.theme.White

/**
 *  NickNameScreen.kt
 *
 *  Created by Minji Jeong on 2022/07/06
 *  Copyright © 2022 GwanakMT All rights reserved.
 */

@Composable
fun NickNameScreen(
    finishMakeNickName: (() -> Unit)? = null
) {
    // TODO(minji): UI 작업 필요
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey500),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {

        }

        Column(modifier = Modifier.weight(1f, false)) {
            Image(
                painter = painterResource(id = R.drawable.damgle_nickname_background),
                contentDescription = "Damgle NickName Background",
                modifier = Modifier
                    .padding(start = 38.dp, bottom = 34.dp)
                    .height(104.dp)
            )

            Text(
                textAlign = TextAlign.Center,
                text = "시작하기",
                modifier = Modifier
                    .background(Orange500)
                    .fillMaxWidth()
                    .height(64.dp)
                    .clickable { finishMakeNickName?.invoke() }
                    .padding(vertical = 20.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 18.sp,
                )
            )
        }
    }
}
