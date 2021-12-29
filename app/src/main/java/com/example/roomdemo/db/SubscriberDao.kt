package com.example.roomdemo.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/28/21.
 */
@Dao
interface SubscriberDao {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber) : Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAllSubscriber() : Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscriber():Flow<List<Subscriber>>
}