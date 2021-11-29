package com.example.homework21.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "topic")
    val topic: String,

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "date")
    val date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}