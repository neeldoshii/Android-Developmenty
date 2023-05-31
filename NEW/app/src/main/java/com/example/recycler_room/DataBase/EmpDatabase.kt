package com.example.recycler_room.DataBase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [EmpData::class], version = 1)
abstract class EmpDatabase:RoomDatabase(){
    abstract fun empDataAccess() : EmpDao

}