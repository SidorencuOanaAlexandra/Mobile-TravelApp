package com.example.crud.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "travelplace_table")
data class TravelPlace (
    @PrimaryKey(autoGenerate = true)  var id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "city")val city:String,
    @ColumnInfo(name = "lat")val lat:String,
    @ColumnInfo(name = "long")val long:String,
    @ColumnInfo(name = "description")val description:String,
    @ColumnInfo(name = "availability")val availability:String,
    @ColumnInfo(name = "imgUrl")val imgUrl:String
)
