package com.abdallah.roomwordsample.data_layer.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */

@Entity(tableName = "word_table")
data class Word(@PrimaryKey val word: String)