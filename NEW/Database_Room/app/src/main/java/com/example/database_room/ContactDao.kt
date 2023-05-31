package com.example.database_room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao{
   @Insert
  suspend fun insertdata(xyz:Employee) // xyz is a object and Employee is data class

   @Delete
   suspend fun deletedata(xyz:Employee) // xyz is a object and Employee is data class

   @Update
   suspend fun updatedata(xyz:Employee) // xyz is a object and Employee is data class

   @Query("Select * from Employee")
     fun getdataemp() : LiveData<List<Employee>>

}