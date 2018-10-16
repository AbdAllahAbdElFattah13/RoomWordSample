package com.abdallah.roomwordsample

import android.app.Application
import io.realm.Realm


/**
 * Created by AbdAllah AbdElfattah on 16/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class WordsRoomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}