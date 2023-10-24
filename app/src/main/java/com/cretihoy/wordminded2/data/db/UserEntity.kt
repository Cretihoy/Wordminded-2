package com.cretihoy.wordminded2.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey
    val id: Long,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val score: Long
)