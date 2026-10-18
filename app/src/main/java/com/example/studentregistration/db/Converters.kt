package com.example.studentregistration.db

import androidx.room.TypeConverter
import java.util.Date
/*
Class needed to convert Date to Long and vice versa
 */
class Converters {

    @TypeConverter
    fun fromDate(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time : Long) : Date{
        return Date(time)
    }

}