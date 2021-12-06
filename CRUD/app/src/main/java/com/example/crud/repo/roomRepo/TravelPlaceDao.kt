package com.example.crud.repo.roomRepo

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.crud.domain.TravelPlace

@Dao
interface TravelPlaceDao {

    @Query("SELECT * FROM travelplace_table")
    fun getAll(): LiveData<List<TravelPlace>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: TravelPlace)

    @Delete
    fun delete(user: TravelPlace)

    @Update
    fun update(user: TravelPlace)

    @Query("DELETE FROM travelplace_table")
    fun deleteAll()


}