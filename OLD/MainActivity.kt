    package appp.prova.morracinese

    import android.view.LayoutInflater
    import android.os.Bundle
    import android.view.View
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import android.widget.TextView


    class MainActivity : AppCompatActivity() {

        val SCELTA = arrayOf("Sasso", "Carta", "Forbici")

        lateinit var titoloRisultato :TextView
        lateinit var motivoRisultato :TextView

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val InflaterInitializer = LayoutInflater.from(applicationContext) as LayoutInflater
        val inflater = InflaterInitializer.inflate(R.layout.activity_outcome, null, false)

        titoloRisultato = inflater.findViewById(R.id.titoloRisultato) as TextView
        motivoRisultato = inflater.findViewById(R.id.motivoRisultato) as TextView


    }

    fun initScreen(v :View) {
        setContentView(R.layout.activity_main)
    }

    fun gameScreen(v :View) {
        setContentView(R.layout.activity_game)
    }

    fun resultScreen() {
        setContentView(R.layout.activity_outcome)
    }


    fun choiceisCarta(v :View) {
        val userChoice = "Carta"
        val computerChoice = getComputerChoice()
        if (userChoice == computerChoice) {
            pareggio(computerChoice)
        } else {
            runOnUiThread {
                this.titoloRisultato.text =
                    if (computerChoice == "Forbici") getString(R.string.hai_vinto) else getString(R.string.hai_perso);
                motivoRisultato.text = getString(R.string.scelta_pc, computerChoice)
            }
        }; resultScreen()
    }

    fun choiceisSasso(v :View) {
        val userChoice = "Sasso"
        val computerChoice = getComputerChoice()
        if (userChoice == computerChoice) {
            pareggio(computerChoice)
        } else {
            runOnUiThread {
                this.titoloRisultato.text =
                    if (computerChoice == "Sasso") getString(R.string.hai_vinto) else getString(R.string.hai_perso);
                motivoRisultato.text = getString(R.string.scelta_pc, computerChoice)
            }
        }; resultScreen()
    }

    fun choiceisForbici(v :View) {
        val userChoice = "Forbici"
        val computerChoice = getComputerChoice()
        if (userChoice == computerChoice) {
            pareggio(computerChoice)
        } else {
            runOnUiThread {
                this.titoloRisultato.text =
                    if (computerChoice == "Carta") getString(R.string.hai_vinto) else getString(R.string.hai_perso);
                motivoRisultato.text = getString(R.string.scelta_pc, computerChoice)
            }
        }; resultScreen()
    }

    private fun pareggio(cc :String) {
        runOnUiThread {
            titoloRisultato.text = getString(R.string.pareggio)
            motivoRisultato.text = getString(R.string.scelta_tt, cc)
        }; resultScreen()
    }

    private fun getComputerChoice() :String = this.SCELTA[arrayOf(0, 1, 2).random()]
}
