package com.abdallah.roomwordsample.data_layer

import android.app.Application
import android.arch.lifecycle.LiveData
import com.abdallah.roomwordsample.data_layer.local_data_source.room.word.WordDao
import com.abdallah.roomwordsample.data_layer.local_data_source.room.word.WordRoomDatabase
import com.abdallah.roomwordsample.data_layer.models.Word
import kotlin.concurrent.thread


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class WordRepository(application: Application) {

    private val mWordDao: WordDao = WordRoomDatabase.getInstance(application).getWordDao()
    private val mAllWordsLiveData: LiveData<List<Word>> = mWordDao.getAllWords()

    fun getAllWord() = mAllWordsLiveData

    fun insert(word: Word) {
        thread { mWordDao.insert(word) }
    }

}