package com.abdallah.roomwordsample.presentation_layer.words_listing_activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.abdallah.roomwordsample.R
import com.abdallah.roomwordsample.data_layer.models.Word

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlin.properties.Delegates
import android.widget.Toast
import com.abdallah.roomwordsample.presentation_layer.add_word.NewWordActivity
import android.app.Activity

class WordsActivity : AppCompatActivity() {

    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1

    private var mWordsViewModel: WordViewModel by Delegates.notNull()
    private val mWordsAdapter = WordListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupRecyclerView()

        setupTheViewModelObservation()

        fab.setOnClickListener { _ ->
            val intent = Intent(this@WordsActivity, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY))
            mWordsViewModel.insert(word)
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupRecyclerView() {
        recyclerview.adapter = mWordsAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun setupTheViewModelObservation() {
        mWordsViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        mWordsViewModel.getAllWords().observe(this,
            Observer<List<Word>> {
                it?.let { wordsList ->
                    mWordsAdapter.updateWords(wordsList)
                }
            })
    }
}
