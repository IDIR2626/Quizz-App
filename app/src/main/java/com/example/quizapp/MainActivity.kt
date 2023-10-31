package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.ui.QuestionsActivity

private lateinit var name:String


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : Button = findViewById(R.id.start_btn_id)
        val nameField: EditText = findViewById(R.id.name_field_id)



        startBtn.setOnClickListener {
            if (!nameField.text.isEmpty()){
                name = nameField.text.toString()
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    it.putExtra("name", name)
                    startActivity(it)
                }
            }else Toast.makeText(this, "Please Enter your name!", Toast.LENGTH_LONG).show()
        }

    }
}