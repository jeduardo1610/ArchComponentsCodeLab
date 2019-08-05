package com.example.archcomponentscodelab.repositories

import androidx.lifecycle.LiveData
import com.example.archcomponentscodelab.dao.WordDao
import com.example.archcomponentscodelab.models.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

}
