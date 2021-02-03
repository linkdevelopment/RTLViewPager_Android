package com.linkdev.sample.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TabItemData(val tabTitle:String?= null, val itemDescription:String ? = null):
    Parcelable {

}
