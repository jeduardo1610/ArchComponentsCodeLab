package com.example.archcomponentscodelab.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.archcomponentscodelab.dao.WordDao
import com.example.archcomponentscodelab.models.Word

/**
 * When you modify the database schema, you'll need to update the version number and define a migration strategy
 * For a sample, a destroy and re-create strategy can be sufficient. But, for a real app, you must implement a migration strategy. See
 * https://medium.com/google-developers/understanding-migrations-with-room-f01e04b07929
 */
@Database(
    entities = [Word::class],
    version = 1
)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
