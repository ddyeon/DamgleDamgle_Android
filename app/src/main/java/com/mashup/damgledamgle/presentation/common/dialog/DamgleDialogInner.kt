package com.mashup.damgledamgle.presentation.common.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import com.mashup.damgledamgle.ui.theme.*

@Composable
fun DamgleDialogTwoButtonInner(
        title: String,
        description: String,
        firstButtonText: String,
        firstButtonAction: () -> Unit,
        secondButtonText: String,
        secondButtonAction: () -> Unit,
) {
    Column(
            modifier = Modifier
                    .background(color = Grey500)
                    .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
                text = title,
                color = Gray1000,
                style = pretendardTextStyle.bodyMedium18,
                textAlign = Center,
                maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
                text = description,
                style = pretendardTextStyle.bodyMedium14,
                color = Gray600,
                textAlign = Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
                modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
        ) {
            Text(
                    modifier = Modifier
                            .clickable { firstButtonAction() }
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(),
                    textAlign = Center,
                    style = pretendardTextStyle.bodySemibold16,
                    text = firstButtonText,
                    color = Black
            )
            Text(
                    modifier = Modifier
                            .clickable { secondButtonAction() }
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(),
                    textAlign = Center,
                    style = pretendardTextStyle.bodySemibold16,
                    text = secondButtonText,
                    color = Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DamgleDialogOneButtonInner(
    title: String,
    description: String,
    firstButtonText: String,
    firstButtonAction: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Grey500)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = title,
            color = Gray1000,
            textAlign = Center,
            style = pretendardTextStyle.bodyBold18,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            style = pretendardTextStyle.bodyMedium16,
            color = Gray900,
            textAlign = Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .clickable { firstButtonAction() }
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(),
                textAlign = Center,
                style = pretendardTextStyle.bodySemibold16,
                text = firstButtonText,
                color = Gray1000
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
