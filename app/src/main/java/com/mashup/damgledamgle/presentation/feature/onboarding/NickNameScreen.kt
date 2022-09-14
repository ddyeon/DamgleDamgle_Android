package com.mashup.damgledamgle.presentation.feature.onboarding

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.presentation.common.ViewState
import com.mashup.damgledamgle.presentation.feature.home.LoadingLottie
import com.mashup.damgledamgle.presentation.navigation.Screen
import com.mashup.damgledamgle.ui.theme.*

/**
 *  NickNameScreen.kt
 *
 *  Created by Minji Jeong on 2022/07/06
 *  Copyright © 2022 MashUp All rights reserved.
 */

@Composable
fun NickNameScreen(
    navController: NavHostController,
    notification: Boolean
) {
    val context = LocalContext.current
    val viewModel: OnboardingViewModel = hiltViewModel()
    val openNickNameErrorDialog = remember { mutableStateOf(false) }
    val openNickNameQuestionDialog = remember { mutableStateOf(false) }
    val signUpLoadingState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey500)
    ) {
        if (viewModel.nickName.value.nth != 0) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = context.getString(R.string.nickname_maintext),
                        style = pretendardTextStyle.title1Bold32,
                        color = Gray1000,
                        modifier = Modifier.padding(top = 94.dp, bottom = 8.dp, start = 20.dp),
                    )

                    Text(
                        text = context.getString(R.string.nickname_subtext),
                        style = pretendardTextStyle.bodyMedium13,
                        color = Gray900,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Row(
                        modifier = Modifier.padding(top = 56.dp, start = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = context.getString(
                                R.string.nickname_placeholder_count,
                                viewModel.nickName.value.nth
                            ),
                            style = pretendardTextStyle.bodyMedium24,
                            color = Orange500,
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_question),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(24.dp)
                                .clickable { openNickNameQuestionDialog.value = true }
                        )
                    }

                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
                    ) {
                        NickNameBox(viewModel.nickName.value.adjective) {
                            viewModel.refreshNickNameAdjective(viewModel.nickName.value.noun)
                        }

                        NickNameBox(viewModel.nickName.value.noun) {
                            viewModel.refreshNickNameNoun(viewModel.nickName.value.adjective)
                        }
                    }
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
                        text = context.getString(R.string.nickname_button_start),
                        modifier = Modifier
                            .background(Orange500)
                            .fillMaxWidth()
                            .height(64.dp)
                            .clickable { viewModel.signUp(viewModel.nickName.value, notification) }
                            .padding(vertical = 20.dp),
                        style = pretendardTextStyle.bodyMedium18,
                        color = White
                    )
                }
            }
        }

        if (viewModel.uiState.collectAsState().value is ViewState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Orange500
            )
        }

        LaunchedEffect(key1 = viewModel.uiState.collectAsState().value) {
            if (viewModel.uiState.value is ViewState.Error) {
                openNickNameErrorDialog.value = true
            }
        }

        LaunchedEffect(key1 = viewModel.authState.collectAsState().value) {
            when (viewModel.authState.value) {
                is ViewState.Loading -> signUpLoadingState.value = true
                is ViewState.Success -> navController.navigate(Screen.Home.route)
                is ViewState.Error -> {
                    signUpLoadingState.value = false
                    openNickNameErrorDialog.value = true
                }
            }
        }
    }

    if (openNickNameErrorDialog.value) {
        NickNameErrorDialog(
            openNickNameErrorDialog = openNickNameErrorDialog,
            onButtonClick = {
                openNickNameErrorDialog.value = false
                if (viewModel.nickName.value.fullName.isEmpty()) {
                    viewModel.getNickName()
                }
            }
        )
    }

    if (openNickNameQuestionDialog.value) {
        NickNameQuestionDialog(
            nth = viewModel.nickName.value.nth,
            openNickNameErrorDialog = openNickNameQuestionDialog
        )
    }

    if (signUpLoadingState.value) {
        LoadingLottie()
    }
}

@Composable
fun NickNameBox(
    nickName: String,
    onClickRefresh: (() -> Unit)? = null
) {
    Box(
        Modifier
            .width(IntrinsicSize.Max)
            .padding(end = 16.dp)
    ) {
        Text(
            text = nickName,
            style = pretendardTextStyle.bodyMedium24,
            color = Gray1000,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 4.dp, end = 32.dp, bottom = 8.dp)
                .wrapContentSize()
        )

        Divider(
            color = Gray1000,
            modifier = Modifier.align(Alignment.BottomStart),
            thickness = 2.dp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_refresh),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 4.dp, top = 6.dp)
                .size(24.dp)
                .clickable { onClickRefresh?.invoke() }
        )
    }
}

@Preview
@Composable
fun PreviewNickNameBox() {
    NickNameBox("닉네임")
}
