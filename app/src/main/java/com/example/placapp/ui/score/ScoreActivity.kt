package com.example.placapp.ui.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.fiap.ui.score.ScoreViewModel
import com.example.placapp.R
import com.example.placapp.model.Game
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreViewModel = ViewModelProviders.of(this)
            .get(ScoreViewModel::class.java)

        setupView()

        registerObserver()

        btGoalHome.setOnClickListener {
            scoreViewModel.goalHome()
        }

        btAwayGoal.setOnClickListener {
            scoreViewModel.goalAway()
        }

        btRestart.setOnClickListener {
            scoreViewModel.restartGame()
        }

        btFinish.setOnClickListener {
            finish()
        }
    }

    private fun registerObserver() {
        scoreViewModel.goalHome.observe(this, Observer { goalHome ->
            tvGoalHome.text = goalHome.toString()
        })

        scoreViewModel.goalAway.observe(this, Observer { goalAway->
            tvAwayGoal.text = goalAway.toString()
        })
    }

    private fun setupView() {
        /*tvEventName.text = intent.extras?.getString("eventName")
        tvHomeName.text = intent.extras?.getString("homeTeam")
        tvAwayName.text = intent.extras?.getString("awayTeam")*/
        intent.extras?.getParcelable<Game>("game")?.apply {
            tvEventName.text = eventName
            tvHomeName.text = homeTeam
            tvAwayName.text = awayTeam
        }
    }

}

