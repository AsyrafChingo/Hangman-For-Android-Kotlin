package universitas.surabaya

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list_of_items = arrayOf("Luar Angkasa", "Binatang", "City")
    var playername = ""
    var tema = ""
    var level = ""
    var displayImages = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MEMBUAT COMBOBOX
        val combobox = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        // Set layout to use when the list of choices appear
        combobox.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner_category!!.adapter = combobox
        //============================================================================

        //BUTTON START DI KLIK
        btn_start.setOnClickListener{
            //NGAMBIL NAMA PEMAIN
            playername = txt_player_name.text.toString()

            //NGAMBIL GAMBAR TAMPILIN APA GAK
            if(checkBox_display.isChecked)
            {
                displayImages = true
            }

            //NGAMBIL RADIOBUTTON LEVEL
            var id: Int = radiogroup.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio:RadioButton = findViewById(id)
                level = radio.text.toString()
            }

            //NGAMBIL TEMA DARI COMBOBOX
            tema = spinner_category.selectedItem.toString()

            intent = Intent(this, GameActivity::class.java)
            var hangman = Hangman()
            hangman.playerName = playername
            hangman.level = level
            hangman.theme = tema
            hangman.image = displayImages

            intent.putExtra("hangman",  hangman)
            startActivity(intent)
        }
    }
}
