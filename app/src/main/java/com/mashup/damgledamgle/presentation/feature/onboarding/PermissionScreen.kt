package com.mashup.damgledamgle.presentation.feature.onboarding

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.mashup.damgledamgle.R
import com.mashup.damgledamgle.presentation.common.shouldShowPermissionRationale
import com.mashup.damgledamgle.ui.theme.Grey500
import com.mashup.damgledamgle.ui.theme.pretendardTextStyle

/**
 *  PermissionScreen.kt
 *
 *  Created by Minji Jeong on 2022/07/06
 *  Copyright © 2022 MashUp All rights reserved.
 */

@Composable
fun PermissionScreen(
    mainText: String,
    subText: String,
    iconResId: Int,
    permissionLauncher: ManagedActivityResultLauncher<String, Boolean>?,
    permission: String,
) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Grey500)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "Damgle Permission Icon",
            modifier = Modifier
                .padding(top = 88.dp)
                .size(100.dp)
        )

        Text(
            text = mainText,
            style = pretendardTextStyle.bodyBold18,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp),
        )

        Text(
            text = subText,
            style = pretendardTextStyle.bodyMedium16,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp),
        )
    }

    LocalLifecycleOwner.current.lifecycleScope.launchWhenResumed {
        if (!shouldShowPermissionRationale(context, permission)) {
            permissionLauncher?.launch(permission)
        } else {
            // TODO: 앱 설정으로 이동할지 여부 물어보는 Dialog 필요
            val appIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${context.packageName}"))
            appIntent.addCategory(Intent.CATEGORY_DEFAULT)
            appIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(appIntent)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPermissionScreen() {
    val context = LocalContext.current

    PermissionScreen(
        mainText = context.getString(R.string.permission_location_maintext),
        subText = context.getString(R.string.permission_location_subtext),
        iconResId = R.drawable.ic_permission_location,
        permissionLauncher = null,
        permission = Manifest.permission.ACCESS_FINE_LOCATION
    )
}
