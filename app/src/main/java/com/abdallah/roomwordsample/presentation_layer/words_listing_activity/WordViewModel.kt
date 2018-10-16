package com.abdallah.roomwordsample.presentation_layer.words_listing_activity

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.abdallah.roomwordsample.data_layer.WordRepository
import com.abdallah.roomwordsample.data_layer.models.Word


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepo: WordRepository = WordRepository(application)
    private val mWords: LiveData<List<Word>>

    init {
        mWords = mRepo.getAllWord()
    }

    fun getAllWords() = mWords

    fun insert(word: Word) = mRepo.insert(word)
}