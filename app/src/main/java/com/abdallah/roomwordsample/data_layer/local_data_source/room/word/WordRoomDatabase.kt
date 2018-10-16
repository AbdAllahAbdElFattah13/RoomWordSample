package com.abdallah.roomwordsample.data_layer.local_data_source.room.word

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.abdallah.roomwordsample.data_layer.models.Word
import android.arch.persistence.room.Room
import kotlin.concurrent.thread


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun getWordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java, "word_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            thread {
                                val dao = INSTANCE?.getWordDao()
                                dao?.deleteAll()

                                dao?.insert(Word("Hello"))
                                dao?.insert(Word("World!"))
                            }
                        }
                    })
                    .build().also { INSTANCE = it }
            }
    }
}