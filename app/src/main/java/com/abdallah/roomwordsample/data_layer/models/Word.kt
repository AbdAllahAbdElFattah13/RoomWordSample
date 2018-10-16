package com.abdallah.roomwordsample.data_layer.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */

open class Word(@PrimaryKey var word: String = "") : RealmObject()