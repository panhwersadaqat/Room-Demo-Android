package com.example.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 12/28/21.
 */

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDao : SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE: SubscriberDatabase? = null
            fun getInstance(context: Context):SubscriberDatabase{
                synchronized(this){
                    var instance: SubscriberDatabase? = INSTANCE
                    if(instance==null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            SubscriberDatabase::class.java,
                            "subscriber_data_table"
                        ).build()
                    }
                    return instance
                }
            }
    }

}

