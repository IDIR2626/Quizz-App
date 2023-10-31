package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {
    fun getQuestions():MutableList<Question>{
        val  questions = mutableListOf<Question>()

        val quest1 = Question(
            1,
            "what country does this flag represent?",
            R.drawable.palestine_flag,
            "Palestine",
            "Jordan",
            "Sudan",
            "egypt",
            1
        )
        val quest2 = Question(
            2,
            "what country does this flag represent?",
            R.drawable.algeria_flag,
            "Wales",
            "Italy",
            "Algeria",
            "Hungary",
            3

        )

        val quest3 = Question(
            3,
            "what country does this flag represent?",
            R.drawable.canada_flag,
            "Peru",
            "Canada",
            "Tunisia",
            "Latvia",
            2
            )
        val quest4 = Question(
            4,
            "what country does this flag represent?",
            R.drawable.australia_flag,
            "New zealand",
            "USA",
            "United kingdom",
            "Australia",
            4
            )

        val quest5 = Question(
            5,
            "what country does this flag represent?",
            R.drawable.belgium_flag,
            "Germany",
            "Belgium",
            "France",
            "Armenia",
            2
            )

        val quest6 = Question(
            6,
            "what country does this flag represent?",
            R.drawable.us_flag,
            "New zealand",
            "USA",
            "United kingdom",
            "Australia",
            2
        )

        val quest7 = Question(
            7,
            "what country does this flag represent?",
            R.drawable.portugal_flag,
            "Portugal",
            "Brazil",
            "Argentina",
            "Mexico",
            1
            )
        val quest8 = Question(
            8,
            "what country does this flag represent?",
            R.drawable.japan_flag,
            "South Korea",
            "China",
            "Japan",
            "Bangladesh",
            3
            )

        val quest9 = Question(
            9,
            "what country does this flag represent?",
            R.drawable.italy_flag,
            "Wales",
            "Italy",
            "Mexico",
            "Hungary",
            2
        )

        val quest10 = Question(
            10,
            "what country does this flag represent?",
            R.drawable.luxembourg_flag,
            "Netherlands",
            "France",
            "Russia",
            "Luxembourg",
            4
            )
        questions.add(quest1)
        questions.add(quest2)
        questions.add(quest3)
        questions.add(quest4)
        questions.add(quest5)
        questions.add(quest6)
        questions.add(quest7)
        questions.add(quest8)
        questions.add(quest9)
        questions.add(quest10)



        return questions
    }
}