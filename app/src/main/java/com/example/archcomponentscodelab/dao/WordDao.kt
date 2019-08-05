package com.example.archcomponentscodelab.dao

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

    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}

