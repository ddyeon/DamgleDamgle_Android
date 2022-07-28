package com.mashup.damgledamgle.presentation.feature.home

import android.graphics.Bitmap
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mashup.damgledamgle.R

class HomeViewModel : ViewModel()  {

    private val _iconRes = mutableStateOf(R.drawable.ic_angry_small)
    val iconsRes  : State<Int> = _iconRes

    fun changeMarkerValue(resId : Int) {
        _iconRes.value = resId
    }

    private var _onBitmapCreated = MutableLiveData<Bitmap?>(null)
    var onBitmapGenerated: LiveData<Bitmap?> = _onBitmapCreated

    fun bitmapCreated(bitmap: Bitmap?) {
        _onBitmapCreated.value = bitmap
    }

    //서버에서 받는 마커 표시 위치 ArrayList<Info>
    //Info는 아이콘, 읽음 처리, 위도 경도에 대한 정보를 담은 data class
    fun getMakerList() : ArrayList<MakerInfo> {
        val list : ArrayList<MakerInfo> = arrayListOf()

        list.add(MakerInfo(R.drawable.ic_heart_small,false, true,37.5455113, 127.0657011,0))
        list.add(MakerInfo(R.drawable.ic_angry_small,true, false,37.5448118, 127.0649041,0))
        list.add(MakerInfo(R.drawable.ic_amazing_small,false, false,37.54529, 127.06630,56))

        return list
    }
}

data class MakerInfo(
    val resId: Int,
    val isRead: Boolean,
    val isMine :Boolean,
    val latitude: Double,
    val longitude: Double,
    val size : Int
)