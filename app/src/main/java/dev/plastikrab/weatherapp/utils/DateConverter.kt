package dev.plastikrab.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class DateConverter(
    private val unixTimestamp: Long
) {
    val date = Date(unixTimestamp * 1000)


    fun getDateTime(): String {
        val dayOfMonth = date.date.toString()

        when (date.month){
            0 -> return "$dayOfMonth Jan"
            1 -> return "$dayOfMonth Feb"
            2 -> return "$dayOfMonth Mar"
            3 -> return "$dayOfMonth Apr"
            4 -> return "$dayOfMonth May"
            5 -> return "$dayOfMonth Jun"
            6 -> return "$dayOfMonth Jul"
            7 -> return "$dayOfMonth Aug"
            8 -> return "$dayOfMonth Sep"
            9 -> return "$dayOfMonth Oct"
            10 -> return "$dayOfMonth Nov"
            11 -> return "$dayOfMonth Dec"
        }
        return "dayOfMonth"
    }


    fun getDayOfWeek(): String {
        when (date.day){
            0 -> return "Mon"
            1 -> return "Tue"
            2 -> return "Wed"
            3 -> return "Thu"
            4 -> return "Fri"
            5 -> return "Sat"
            6 -> return "Sun"
        }
        return "dayOfWeek"
    }

    fun getTime(): String {
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        timeFormat.timeZone = TimeZone.getTimeZone("UTC")
        return timeFormat.format(date)
    }
}