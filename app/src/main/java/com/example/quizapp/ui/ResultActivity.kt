package com.example.quizapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R

@SuppressLint("StaticFieldLeak")
private lateinit var userName:TextView
@SuppressLint("StaticFieldLeak")
private lateinit var finalScore:TextView
@SuppressLint("StaticFieldLeak")
private lateinit var finshBtn:Button

class ResultActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        userName = findViewById(R.id.userNameTextView)
        finalScore = findViewById(R.id.score_textView)
        finshBtn = findViewById(R.id.finish_btn)

        val name = intent.getStringExtra("name")
        val score = intent.getStringExtra("score")

        userName.text = name
        finalScore.text = "Your Score is $score Of 10"


    }

    override fun onClick(view: View?) {

        when(view?.id){
            finshBtn.id ->{

            }
        }

    }
}


