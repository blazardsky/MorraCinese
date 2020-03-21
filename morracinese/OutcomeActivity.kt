package space.blazardsky.morracinese

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton


class OutcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outcome)

        val daCapo = findViewById<AppCompatImageButton>(R.id.da_capo)
        val esci = findViewById<AppCompatImageButton>(R.id.esci)

        val titolo :TextView = findViewById(R.id.titoloRisultato)
        val motivo :TextView = findViewById(R.id.motivoRisultato)

        titolo.text = intent.extras!!.getString("TITOLO", "Ops")
        motivo.text = intent.extras!!.getString("MOTIVO", "Qualcosa è andato storto..")

        Toast.makeText(this, titolo.text, Toast.LENGTH_SHORT).show()
        titolo.postInvalidate()
        motivo.invalidate()

        daCapo.setOnClickListener {
            startActivity(Intent(this@OutcomeActivity, GameActivity::class.java))
        }
        esci.setOnClickListener {
            startActivity(Intent(this@OutcomeActivity, MainActivity::class.java))
        }

    }

}

