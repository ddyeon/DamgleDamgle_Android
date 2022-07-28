package com.mashup.damgledamgle.presentation.common

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.*

/**
 *  BackPressInterceptor.kt
 *
 *  Created by Minji Jeong on 2022/07/04
 *  Copyright © 2022 MashUp All rights reserved.
 */

private const val BACK_PRESS_WAIT_TIME = 1500

@Composable
fun BackPressInterceptor(
    context: Context,
    onBackPressed: (() -> Unit)? = null
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    var backPressWaitTime by remember { mutableStateOf(0L) }

    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed ?: {
        if (System.currentTimeMillis() - backPressWaitTime >= BACK_PRESS_WAIT_TIME) { // 1.5초 안에 뒤로가기 두 번 눌러야 앱 종료.
            backPressWaitTime = System.currentTimeMillis()
            Toast.makeText(context, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            (context as? Activity)?.finish()
        }
    })

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher?.addCallback(backCallback)

        onDispose {
            backCallback.remove()
        }
    }
}
