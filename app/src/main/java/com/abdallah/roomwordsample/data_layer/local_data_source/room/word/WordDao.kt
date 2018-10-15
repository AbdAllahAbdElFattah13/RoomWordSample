package com.abdallah.roomwordsample.data_layer.local_data_source.room.word

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.abdallah.roomwordsample.data_layer.models.Word


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("delete from word_table")
    fun deleteAll()

    @Query("select * from word_table order by word asc")
    fun getAllWords(): LiveData<List<Word>>

}