package com.souvikbiswas.quotestrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.souvikbiswas.quotestrivia.databinding.FragmentLostBinding

class LostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLostBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_lost, container, false
        )

        return binding.root
    }
}