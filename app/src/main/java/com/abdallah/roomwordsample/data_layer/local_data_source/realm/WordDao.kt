package com.abdallah.roomwordsample.data_layer.local_data_source.realm

import android.arch.lifecycle.LiveData
import com.abdallah.roomwordsample.data_layer.local_data_source.realm.utills.RealmResultsLiveData
import com.abdallah.roomwordsample.data_layer.models.Word
import io.realm.Realm
import io.realm.Sort


/**
 * Created by AbdAllah AbdElfattah on 16/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class WordDao {

    fun insert(word: Word) {
        Realm.getDefaultInstance().executeTransactionAsync { it.insertOrUpdate(word) }
    }

    fun insertAll(words: List<Word>) {
        Realm.getDefaultInstance().executeTransactionAsync { it.insertOrUpdate(words) }
    }

    fun deleteAll() {
        Realm.getDefaultInstance().executeTransactionAsync { it.delete(Word::class.java) }
    }

    fun getAllWords(): LiveData<List<Word>> =
        RealmResultsLiveData(
            Realm.getDefaultInstance().where(
                Word::class.java
            ).sort("word", Sort.ASCENDING).findAllAsync()
        )
}