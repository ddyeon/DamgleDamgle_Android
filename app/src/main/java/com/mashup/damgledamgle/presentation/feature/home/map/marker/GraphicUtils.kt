package com.mashup.damgledamgle.presentation.feature.home.map.marker

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import com.mashup.damgledamgle.R

class GraphicUtils {
    fun createBitmapFromView(view: View, width: Int, height: Int): Bitmap {
        view.layoutParams = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )

        view.measure(
            View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        )

        view.layout(0, 0, width, height)

        val canvas = Canvas()
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        canvas.setBitmap(bitmap)
        view.draw(canvas)

        return bitmap
    }
}


fun makeMarkerCustomBitmap(context: Context, iconRes : Int, isMine : Boolean, isRead : Boolean, count : Int): Bitmap? {
    val conf = Bitmap.Config.ARGB_8888
    val bmp = Bitmap.createBitmap(250, 250, conf)
    val canvas = Canvas(bmp)

    val balloonRes = if(isMine) R.drawable.ic_text_balloon
    else R.drawable.ic_text_balloon

    val drawPaint = Paint()
    drawPaint.color = Color.BLACK

    canvas.drawBitmap(
        BitmapFactory.decodeResource(
            context.resources,
            balloonRes
        ), 0F, 20F, drawPaint
    )

    canvas.drawBitmap(
        BitmapFactory.decodeResource(
            context.resources,
            iconRes
        ), 50F, 48F, drawPaint
    )

    if(!isRead && count <=1) {
        val notifyCircle = Paint()
        notifyCircle.color = Color.parseColor("#DBFD56")
        canvas.drawCircle(170f,56f,16f,notifyCircle)
    }
    else if(count > 1) {
        val totalResult = if(count > 100) "99+" else "$count"

        val countCircle = Paint()
        countCircle.color = Color.parseColor("#DBFD56")

        canvas.drawCircle(192f,40f,40f,countCircle)
        countCircle.color = Color.parseColor("#212121")
        countCircle.strokeWidth = 3f
        countCircle.style = Paint.Style.STROKE
        canvas.drawCircle(192f,42f,40f,countCircle)

        drawPaint.textSize = 34F
        drawPaint.textAlign = Paint.Align.CENTER
        canvas.drawText(totalResult,192f,56f, drawPaint)

    }

    return bmp
}
