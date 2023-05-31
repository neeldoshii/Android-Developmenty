package com.example.recycler_room.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee")
data class EmpData(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val fName:String,
    val lName:String,
    val phoneNo :Int
)
