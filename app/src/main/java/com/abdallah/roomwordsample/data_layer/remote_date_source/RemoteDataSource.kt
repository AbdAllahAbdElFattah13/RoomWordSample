package com.abdallah.roomwordsample.data_layer.remote_date_source

import android.os.Handler
import android.os.Looper
import com.abdallah.roomwordsample.data_layer.models.Word
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread


/**
 * Created by AbdAllah AbdElfattah on 16/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class RemoteDataSource {

    private val mHandler = Handler(Looper.getMainLooper())

    private val mRandom = Random()

    fun getWordsListFromServer(onSuccess: (List<Word>) -> Unit) {
        thread {
            Thread.sleep(mRandom.nextInt(1500).toLong())

            val toReturn: MutableList<Word> = ArrayList()
            for (i in 0 until 5) {
                toReturn.add(Word(mRandom.nextInt(50).toString()))
            }

            mHandler.post {
                onSuccess(toReturn.toList())
            }
        }
    }
}