package com.abdallah.roomwordsample.data_layer.local_data_source.realm.utills

import android.arch.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmObject
import io.realm.RealmResults


/**
 * Created by AbdAllah AbdElfattah on 16/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class RealmResultsLiveData<T : RealmObject>(results: RealmResults<T>) : LiveData<List<T>>() {

    private val mResults = results
    private val mRealmChangeListener: RealmChangeListener<RealmResults<T>> = RealmChangeListener { value = it }

    override fun onActive() {
        super.onActive()
        mResults.addChangeListener(mRealmChangeListener)
    }

    override fun onInactive() {
        super.onInactive()
        mResults.removeChangeListener(mRealmChangeListener)
    }
}