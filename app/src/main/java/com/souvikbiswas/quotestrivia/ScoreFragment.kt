package com.souvikbiswas.quotestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.souvikbiswas.quotestrivia.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentScoreBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_score, container, false
        )

        return binding.root
    }
}