package com.kluivert.covid19updates

import java.text.NumberFormat
import java.util.*

fun formatNumber(num: Number): String =
    NumberFormat.getNumberInstance(Locale.getDefault()).format(num)


