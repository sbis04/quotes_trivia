package com.souvikbiswas.quotestrivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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

        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(WonFragmentDirections.actionWonFragmentToTriviaFragment())
        }

        correctAnswersText = binding.correctAnswersText
        totalQuestionsText = binding.totalQuestionsText

        val args = WonFragmentArgs.fromBundle(requireArguments())

        correctAnswersText.text = args.numCorrect.toString()
        totalQuestionsText.text = args.numQuestions.toString()

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun getShareIntent(): Intent {
        val args = WonFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_text, args.numCorrect, args.numQuestions)
            )
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
}