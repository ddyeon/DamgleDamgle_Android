package com.mashup.damgledamgle.presentation.common

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 *  PermissionFunctions.kt
 *
 *  Created by Minji Jeong on 2022/07/22
 *  Copyright © 2022 GwanakMT All rights reserved.
 */

/**
 * 현재 특정 권한을 가지고 있는지 확인.
 */
fun checkPermissionSelf(context: Context, permission: String): Boolean {
    return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}

/**
 * 특정 권한을 거부한적 있는지 확인.
 * 거부했다면 true
 */
fun shouldShowPermissionRationale(context: Context, permission: String): Boolean {
    val activity = context as Activity
    return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
}
