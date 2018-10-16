package com.abdallah.roomwordsample.data_layer.remote_date_source

import com.abdallah.roomwordsample.data_layer.models.Word
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by AbdAllah AbdElfattah on 16/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class RemoteDataSource {

    private val mRandom = Random()

    fun getWordsListFromServer(onSuccess: (List<Word>) -> Unit, onError: (errorMsg: String) -> Unit) {
        Thread.sleep(mRandom.nextInt(1000).toLong())

        val toReturn: MutableList<Word> = ArrayList()
        for (i in 0..5) {
            toReturn.add(Word(mRandom.nextInt().toString()))
        }
        onSuccess(toReturn.toList())
    }
}