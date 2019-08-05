package com.example.archcomponentscodelab.dao

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.archcomponentscodelab.models.Word

/**
 * Tip: When inserting data, you can provide a conflict strategy.
 * In this codelab, you do not need a conflict strategy, because the word is your primary key,
 * and the default SQL behavior is ABORT, so that you cannot insert two items with the same primary key into the database.
 * If the table has more than one column, you can use
 * @Insert(onConflict = OnConflictStrategy.REPLACE)
 */

@Dao
interface WordDao {
    /**
     * You must call this on a non-UI thread or your app will crash.
     * Room ensures that you don't do any long-running operations on the main thread, blocking the UI.
     * Add the @WorkerThread annotation, to mark that this method needs to be called from a non-UI thread.
     * Add the suspend modifier to tell the compiler that this needs to be called from a coroutine or another suspending function.
     */
    @WorkerThread
    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}

