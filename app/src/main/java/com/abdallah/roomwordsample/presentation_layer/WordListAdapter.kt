package com.abdallah.roomwordsample.presentation_layer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abdallah.roomwordsample.R
import com.abdallah.roomwordsample.data_layer.models.Word
import kotlin.properties.Delegates


/**
 * Created by AbdAllah AbdElfattah on 15/10/2018,
 * The D. GmbH,
 * Cairo, Egypt.
 */
class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {


    private var mWords: List<Word> = ArrayList()

    fun updateWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)

        return WordViewHolder(itemView)
    }

    override fun getItemCount(): Int = mWords.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val currentWord = mWords[position]
        holder.bind(currentWord)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mWordTextView = itemView.findViewById<TextView>(R.id.textView)

        fun bind(word: Word) {
            mWordTextView.text = word.word
        }

    }
}