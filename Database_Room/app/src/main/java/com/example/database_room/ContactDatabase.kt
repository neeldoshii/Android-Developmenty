package com.example.database_room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class ContactDatabase :RoomDatabase() {

    abstract fun contactdao():ContactDao


}