package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(Contact : Contact)

    @Update
    suspend fun updateContact(Contact: Contact)

    @Delete
    suspend fun  deleteContact(Contact: Contact)

    @Query("SELECT * FROM contactDao")
    fun  getAllContact() : LiveData<List<Contact>>

}