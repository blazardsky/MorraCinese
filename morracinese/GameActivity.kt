package space.blazardsky.morracinese

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton


class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val cartaBtn = findViewById<AppCompatImageButton>(R.id.carta)
        val sassoBtn = findViewById<AppCompatImageButton>(R.id.sasso)
        val forbiciBtn = findViewById<AppCompatImageButton>(R.id.forbici)

        //init var
        var __titolo__:String = ""; var __motivo__:String = ""

        cartaBtn.setOnClickListener {
            val userChoice = "Carta"
            var computerChoice = getComputerChoice()
            if (userChoice == computerChoice) {
                pareggio(computerChoice)
            } else {
                if (computerChoice == "Sasso") {
                    __titolo__ = getString(
                        R.string.hai_vinto
                    )
                } else {
                    __titolo__ = getString(
                        R.string.hai_perso
                    )
                }
                __motivo__ = getString(R.string.scelta_pc, computerChoice)
            }; getOutcomeRes(TDATA = __titolo__, MDATA = __motivo__)
        }

        sassoBtn.setOnClickListener {
            val userChoice = "Sasso"
            var computerChoice = getComputerChoice()
            if (userChoice == computerChoice) {
                pareggio(computerChoice)
            } else {
                if (computerChoice == "Forbici") {
                    __titolo__ = getString(
                        R.string.hai_vinto
                    )
                } else {
                    __titolo__ = getString(
                        R.string.hai_perso
                    )
                }
                __motivo__ = getString(R.string.scelta_pc, computerChoice)
            }; getOutcomeRes(TDATA = __titolo__, MDATA = __motivo__)
        }

        forbiciBtn.setOnClickListener {
            val userChoice = "Forbici"
            var computerChoice = getComputerChoice()
            if (userChoice == computerChoice) {
                pareggio(computerChoice)
            } else {
                if (computerChoice == "Carta") {
                    __titolo__ = getString(
                        R.string.hai_vinto
                    )
                } else {
                    __titolo__ = getString(
                        R.string.hai_perso
                    )
                }
                __motivo__ = getString(R.string.scelta_pc, computerChoice)
            }; getOutcomeRes(TDATA = __titolo__, MDATA = __motivo__)
        }
    }

    private fun pareggio(cc :String) {
        val __titolo__ = getString(R.string.pareggio)
        val __motivo__ = getString(R.string.scelta_tt, cc)
        getOutcomeRes(TDATA = __titolo__, MDATA = __motivo__)
    }

    private fun getComputerChoice() :String =
        arrayOf("Sasso", "Carta", "Forbici")[arrayOf(0, 1, 2).random()]

    private fun getOutcomeRes(TDATA :String, MDATA :String) {
        val extras = Bundle()
        extras.putString("TITOLO", TDATA)
        extras.putString("MOTIVO", MDATA)
        val intent = Intent(this@GameActivity, OutcomeActivity::class.java)
        intent.putExtras(extras)
        this@GameActivity.startActivity(intent)
    }

}