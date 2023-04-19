package com.example.youtube.data.local

import androidx.room.TypeConverter
import com.example.youtube.model.Item
import com.example.youtube.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converter {

    val gson = Gson()

    @TypeConverter
    fun jsonToItems(data: String?) : List<Item> {
        val listType: Type = object : TypeToken<List<Item>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun itemsToString(items: List<Item>): String {
        return gson.toJson(items)
    }

    @TypeConverter
    fun jsonToPageInfo(data: String?): PageInfo {
        return gson.fromJson(data, PageInfo::class.java)
    }

    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo): String {
        return gson.toJson(pageInfo)
    }
}