package com.mashup.damgledamgle.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mashup.damgledamgle.R

/**
 *  Font.kt
 *
 *  Created by Minji Jeong on 2022/07/17
 *  Copyright © 2022 MashUp All rights reserved.
 */

data class Pretendard(
    val title1Bold32: TextStyle,
    val bodyMedium24: TextStyle,
    val bodyBold18: TextStyle,
    val bodyMedium18: TextStyle,
    val bodySemibold16: TextStyle,
    val bodyMedium16: TextStyle,
    val bodyBold13: TextStyle,
    val bodyMedium13: TextStyle,
    val bodySemibold11: TextStyle,
    val bodySemibold10: TextStyle,
)

data class AkzidenzGrotesk(
    val title1Bold32: TextStyle,
    val title2Bold18: TextStyle,
    val body1Bold20: TextStyle,
    val body2Bold13: TextStyle,
)

val pretendard = FontFamily(
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

val akzidenzGrotesk = FontFamily(
    Font(R.font.akzidenz_grotesk_bold),
)

val pretendardTextStyle = Pretendard(
    title1Bold32 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = (-1).sp
    ),
    bodyMedium24 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = (-0.3).sp
    ),
    bodyBold18 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = (-0.3).sp
    ),
    bodyMedium18 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = (-0.3).sp
    ),
    bodySemibold16 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = (-0.3).sp
    ),
    bodyMedium16 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = (-0.3).sp
    ),
    bodyBold13 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = (-0.3).sp
    ),
    bodyMedium13 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        letterSpacing = (-0.3).sp
    ),
    bodySemibold11 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        letterSpacing = (-0.3).sp
    ),
    bodySemibold10 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        letterSpacing = (-0.3).sp
    )
)

val akzidenzGroteskTextStyle = AkzidenzGrotesk(
    title1Bold32 = TextStyle(
        fontFamily = akzidenzGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    title2Bold18 = TextStyle(
        fontFamily = akzidenzGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    body1Bold20 = TextStyle(
        fontFamily = akzidenzGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body2Bold13 = TextStyle(
        fontFamily = akzidenzGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp
    )
)
