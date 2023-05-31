package com.example.recycler_room.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(employee : EmpData)

    @Update
    suspend fun updateData(employee : EmpData)

    @Delete
    suspend fun deleteData(employee : EmpData)

    @Query("SELECT * FROM Employee")
    fun getAll(): LiveData<List<EmpData>>
}
