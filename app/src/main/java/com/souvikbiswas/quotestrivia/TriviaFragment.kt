package com.souvikbiswas.quotestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.souvikbiswas.quotestrivia.databinding.FragmentTriviaBinding
import com.souvikbiswas.quotestrivia.databinding.FragmentWelcomeBinding
import kotlin.math.min

class TriviaFragment : Fragment() {
    data class Question(val quote: String, val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            quote = "\"I have nothing to offer but blood, toil, tears and sweat.\"",
            answers = listOf(
                "Winston Churchill", "Sitting Bull", "Nikita Khrushchev", "Charles de Gaulle"
            )
        ),
        Question(
            quote = "\"I consider myself the luckiest man on the face of the earth.\"",
            answers = listOf(
                "Lou Gehrig", "Bill Gates", "Adolf Hitler", "George Washington"
            )
        ),
        Question(
            quote = "\"A desperate disease requires a dangerous remedy.\"",
            answers = listOf(
                "Guy Fawkes", "Louis Pasteur", "David Lloyd George", "Alexander Fleming"
            )
        ),
        Question(
            quote = "\"To appreciate the importance of fitting every human soul for independent action, think for a moment of the immeasurable solitude of self.\"",
            answers = listOf(
                "Elizabeth Cady Stanton",
                "Pope John Paul II",
                "Queen Victoria",
                "George Washington Carver"
            )
        )
    )

    lateinit var currentQuestion: Question
    lateinit var questionNumberText: TextView
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var correctAnswers = 0
    private val numQuestions = 4

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTriviaBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_trivia, container, false
        )

        randomizeQuestions()

        binding.trivia = this

        questionNumberText = binding.questionNumberText

        questionNumberText.text = "${questionIndex + 1} / $numQuestions"

        binding.submitButton.setOnClickListener { view: View ->
            val checkedId = binding.answerChoiceGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondChoiceButton -> answerIndex = 1
                    R.id.thirdChoiceButton -> answerIndex = 2
                    R.id.fourthChoiceButton -> answerIndex = 3
                }
                questionIndex++

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    correctAnswers++
                    Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show()
                }

                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                    questionNumberText.text = "${questionIndex + 1} / $numQuestions"
                } else {
                    view.findNavController().navigate(R.id.action_triviaFragment_to_scoreFragment)
                }
            }
        }

        return binding.root
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }

}