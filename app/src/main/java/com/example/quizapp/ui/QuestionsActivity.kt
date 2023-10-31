package com.example.quizapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

@SuppressLint("StaticFieldLeak")
private lateinit var mainQuestion : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var flag : ImageView
@SuppressLint("StaticFieldLeak")
private lateinit var progressBar : ProgressBar
@SuppressLint("StaticFieldLeak")
private lateinit var progressNote : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var questionOne : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var questionTwo : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var questionThree : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var questionFour : TextView
@SuppressLint("StaticFieldLeak")
private lateinit var checkBtn : Button

private var score = 0

private  var questionsCounter : Int = 0

private lateinit var questionsList: MutableList<Question>

private var selectedAnswer = 0
private  lateinit var currentQuestion: Question
private var answered = false

private lateinit var userName:String

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionsCounter = 1

        mainQuestion = findViewById(R.id.question_id)
        flag = findViewById(R.id.flag_img_id)
        progressBar = findViewById(R.id.progress_bar_id)
        progressNote = findViewById(R.id.progress_note_id)
        questionOne = findViewById(R.id.option_1_id)
        questionTwo = findViewById(R.id.option_2_id)
        questionThree = findViewById(R.id.option_3_id)
        questionFour = findViewById(R.id.option_4_id)

        checkBtn = findViewById(R.id.sheck_answer_btn)

        questionOne.setOnClickListener(this)
        questionTwo.setOnClickListener(this)
        questionThree.setOnClickListener(this)
        questionFour.setOnClickListener(this)
        checkBtn.setOnClickListener(this)

         userName = intent.getStringExtra("name").toString()

        questionsList = Constants.getQuestions()

        showNextQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun showNextQuestion(){
        resetOptions()
        val question = questionsList[questionsCounter -1]

        mainQuestion.text = question.question
        flag.setImageResource(question.image)
        progressBar.setProgress(questionsCounter, true)
        progressNote.text = "$questionsCounter/10"
        questionOne.text = question.optionOne
        questionTwo.text = question.optionTwo
        questionThree.text = question.optionThree
        questionFour.text = question.optionFour

        if (questionsCounter == questionsList.size) {
            checkBtn.text="Finish"
            currentQuestion = questionsList[questionsCounter - 1]
        }else {
            checkBtn.text = "Check"
            currentQuestion = questionsList[questionsCounter - 1]
        }

        questionsCounter++
        answered = false
        checkBtn.text = "Check"
    }

    private fun resetOptions(){
        val options: MutableList<TextView> = mutableListOf(
            questionOne,
            questionTwo,
            questionThree,
            questionFour
        )

        for (option in options){
            option.setTextColor(Color.parseColor("#888888"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_back_ground)
        }
    }

    private fun selectOption(textView : TextView, selectOptionNumber:Int){
        resetOptions()

        selectedAnswer = selectOptionNumber

        textView.setTextColor(Color.parseColor("#4516F1"))
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_back_ground)
    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.option_1_id ->{
                selectOption(questionOne, 1)
            }
            R.id.option_2_id ->{
                selectOption(questionTwo, 2)
            }

            R.id.option_3_id ->{
                selectOption(questionThree, 3)
            }
            R.id.option_4_id ->{
                selectOption(questionFour, 4)
            }
            R.id.sheck_answer_btn ->{
                if (!answered){
                    checkAnswer()
                }else{

                    if (currentQuestion.id == questionsList.size){
                        Intent(this@QuestionsActivity, ResultActivity::class.java).also {
                            it.putExtra("name", userName)
                            it.putExtra("score", score.toString())
                            startActivity(it)
                        }

                    }else{showNextQuestion()}

                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer() {
        answered = true


        if (selectedAnswer == currentQuestion.correctAnswer){
            score ++
            when(selectedAnswer){
                1->{
                    questionOne.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                    questionOne.setTextColor(Color.parseColor("#FFFFFF"))

                }
                2->{
                    questionTwo.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                    questionTwo.setTextColor(Color.parseColor("#FFFFFF"))
                }
                3->{
                    questionThree.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                    questionThree.setTextColor(Color.parseColor("#FFFFFF"))
                }
                4->{
                    questionFour.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                    questionFour.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
        }else{
            when(selectedAnswer){
                1->{
                    questionOne.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_back_ground)
                    questionOne.setTextColor(Color.parseColor("#FFFFFF"))
                }
                2->{
                    questionTwo.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_back_ground)
                    questionTwo.setTextColor(Color.parseColor("#FFFFFF"))
                }
                3->{
                    questionThree.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_back_ground)
                    questionThree.setTextColor(Color.parseColor("#FFFFFF"))
                }
                4->{
                    questionFour.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_back_ground)
                    questionFour.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }
        }

        checkBtn.text = "Next"

        showSolution()

    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer

        when(selectedAnswer){
            1->{
                questionOne.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                questionOne.setTextColor(Color.parseColor("#FFFFFF"))

            }
            2->{
                questionTwo.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                questionTwo.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3->{
                questionThree.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                questionThree.setTextColor(Color.parseColor("#FFFFFF"))
            }
            4->{
                questionFour.background = ContextCompat.getDrawable(this, R.drawable.true_option_back_ground)
                questionFour.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }

    }


}