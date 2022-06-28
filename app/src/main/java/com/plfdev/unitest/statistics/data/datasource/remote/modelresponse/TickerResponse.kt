package com.plfdev.unitest.statistics.data.datasource.remote.modelresponse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TickerResponse (
    var high: String,
    var low: String,
    var vol: String,
    var last: String,
    var buy: String,
    var sell: String,
    var open: String,
    var date: Long,
):Parcelable