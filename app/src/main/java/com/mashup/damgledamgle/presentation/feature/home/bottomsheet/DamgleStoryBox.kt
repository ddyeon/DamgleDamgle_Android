package com.mashup.damgledamgle.presentation.feature.home.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.presentation.component.ErrorText

@Composable
fun DamgleStoryBox(
        modifier: Modifier = Modifier,
        backGroundColor: Color,
        textColor: Color
) {
    Card(
            modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = backGroundColor
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        var textErrorState by rememberSaveable { mutableStateOf(false) }
        Column(verticalArrangement = SpaceBetween) {
            val maxTextFieldChar = 100
            val maxLine = 6
            Column {
                TextField(
                        modifier = Modifier
                                .wrapContentHeight(),
                        value = text,
                        onValueChange = {
                            when {
                                it.lines().count() > maxLine -> {
                                    return@TextField
                                }
                                it.length <= maxTextFieldChar -> {
                                    textErrorState = false
                                    text = it
                                }
                                else -> {
                                    textErrorState = true
                                }
                            }
                        },
                        colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = backGroundColor,
                                textColor = textColor,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                        ),
                        maxLines = 6,
                        placeholder = { Text(text = stringResource(id = R.string.home_bottomsheet_leave_your_own_story)) }
                )
                if (textErrorState)
                    ErrorText(
                            modifier = Modifier.padding(horizontal = 24.dp),
                            text = stringResource(id = R.string.home_bottomsheet_you_can_enter_up_to_100_characters)
                    )
            }
            Box(
                    modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
            ) {
                Image(
                        painter = painterResource(R.drawable.ic_doodle1),
                        contentDescription = null,
                        modifier = Modifier
                                .align(Alignment.BottomStart)
                                .scale(1f)
                                .offset(x = 43.dp, y = (-67).dp)

                )
                Image(
                        painter = painterResource(R.drawable.ic_doodle2),
                        contentDescription = null,
                        modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .scale(1f)
                                .offset(x = (20).dp, y = (-35).dp)
                )
                Text(
                        modifier = Modifier
                                .padding(16.dp)
                                .wrapContentWidth()
                                .align(Alignment.BottomEnd),
                        text = "${text.count()}/100 자"
                )
            }
        }
    }
}
