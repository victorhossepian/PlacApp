package com.example.placapp.ui.game.awayteam


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.placapp.R
import com.example.placapp.ui.score.ScoreActivity
import kotlinx.android.synthetic.main.fragment_away_team.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AwayTeamFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNextStep.setOnClickListener {
            nextScreen()
        }
    }
    private fun nextScreen() {
        val nextScreen = Intent(activity, ScoreActivity::class.java)
        startActivity(nextScreen)
        activity?.finish()
    }


}
