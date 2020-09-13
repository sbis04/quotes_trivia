package com.souvikbiswas.quotestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.souvikbiswas.quotestrivia.databinding.FragmentWonBinding

class WonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_won, container, false
        )

        return binding.root
    }
}