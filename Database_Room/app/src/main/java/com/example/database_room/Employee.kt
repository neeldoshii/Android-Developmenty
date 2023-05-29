package com.example.database_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val phone:Int

)
