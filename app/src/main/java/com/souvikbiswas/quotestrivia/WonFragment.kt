package com.souvikbiswas.quotestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.souvikbiswas.quotestrivia.databinding.FragmentWonBinding

class WonFragment : Fragment() {

    private lateinit var correctAnswersText: TextView
    private lateinit var totalQuestionsText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_won, container, false
        )

        correctAnswersText = binding.correctAnswersText
        totalQuestionsText = binding.totalQuestionsText

        val args = WonFragmentArgs.fromBundle(requireArguments())

        correctAnswersText.text = args.numCorrect.toString()
        totalQuestionsText.text = args.numQuestions.toString()

        return binding.root
    }
}