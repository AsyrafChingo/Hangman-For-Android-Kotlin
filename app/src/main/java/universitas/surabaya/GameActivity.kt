package universitas.surabaya

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var g1 = R.drawable.hangman1
    var g2 = R.drawable.hangman2
    var g3 = R.drawable.hangman3
    var g4 = R.drawable.hangman4
    var g5 = R.drawable.hangman5
    var g6 = R.drawable.hangman6
    var g7 = R.drawable.hangman7
    var g8 = R.drawable.hangman8
    var g9 = R.drawable.hangman9
    var g10 = R.drawable.hangman10
    var g11 = R.drawable.hangman11

    //SOAL
    val wordLuarAngkasa = arrayOf(arrayOf("bulan", "planet", "pluto"),arrayOf("andromeda", "meteorit", "bimasakti"),arrayOf("schwarzschild","konstelasi", "supernova "))
    val wordBinatang = arrayOf(arrayOf("sapi", "kuda", "unta"),arrayOf("harimau", "merpati", "kelinci"),arrayOf("kelelawar","cendrawasih", "komodo"))
    val wordKota = arrayOf(arrayOf("palu", "lombok", "solo"),arrayOf("tulungagung", "majelengka", "pamekasan"),arrayOf("bojonegoro","purwokerto", "tasikmalaya"))



    var hangman : Hangman = Hangman()

    var jumlahSalah = 0
    var arrayJawaban : CharArray = CharArray(0)
    var player_name : String = ""
    var soal = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //NERIMA PARCEL DARI MAINACTIVITY
        hangman = intent.getParcelableExtra("hangman") as Hangman
        txt_level.setText(hangman.level)
        txt_tema.setText(hangman.theme)

        //NGAMBIL NAMA PEMAIN DARI PAKET DATA INTENT
        player_name = hangman.playerName

        //NGECHECK GAMBAR DARI PAKET
        if (hangman.image == false)
        {
            imgHangman.visibility = View.GONE
        }

        var r = 0
        if(hangman.theme.equals("Luar Angkasa"))
        {
            if (hangman.level.equals("EASY"))
            {

                r = Random.nextInt(0,wordLuarAngkasa[0].count())
                soal = wordLuarAngkasa[0][r]
                arrayJawaban = CharArray(soal.length)

            }
            else if (hangman.level.equals("MEDIUM"))
            {

                r = Random.nextInt(0,wordLuarAngkasa[1].count())
                soal = wordLuarAngkasa[1][r]
                arrayJawaban = CharArray(soal.length)
            }
            else if (hangman.level.equals("HARD"))
            {

                r = Random.nextInt(0,wordLuarAngkasa[2].count())
                soal = wordLuarAngkasa[2][r]
                arrayJawaban = CharArray(soal.length)
            }
            masukkanHuruf(soal, arrayJawaban, '*')
            printWord(soal, arrayJawaban)
        }
        else if(hangman.theme.equals("Binatang"))
        {
            if (hangman.level.equals("EASY"))
            {

                r = Random.nextInt(0,wordBinatang[0].count())
                soal = wordBinatang[0][r]
                arrayJawaban = CharArray(soal.length)
            }
            else if (hangman.level.equals("MEDIUM"))
            {

                r = Random.nextInt(0,wordBinatang[1].count())
                soal = wordBinatang[1][r]
                arrayJawaban = CharArray(soal.length)
            }
            else if (hangman.level.equals("HARD"))
            {

                r = Random.nextInt(0,wordBinatang[2].count())
                soal = wordBinatang[2][r]
                arrayJawaban = CharArray(soal.length)
            }
            masukkanHuruf(soal, arrayJawaban, '*')
            printWord(soal, arrayJawaban)

        }
        else if(hangman.theme.equals("City"))
        {
            if (hangman.level.equals("EASY"))
            {

                r = Random.nextInt(0,wordKota[0].count())
                soal = wordKota[0][r]
                arrayJawaban = CharArray(soal.length)
            }
            else if (hangman.level.equals("MEDIUM"))
            {

                r = Random.nextInt(0,wordKota[1].count())
                soal = wordKota[1][r]
                arrayJawaban = CharArray(soal.length)
            }
            else if (hangman.level.equals("HARD"))
            {

                r = Random.nextInt(0,wordKota[2].count())
                soal = wordKota[2][r]
                arrayJawaban = CharArray(soal.length)
            }
            masukkanHuruf(soal, arrayJawaban, '*')
            printWord(soal, arrayJawaban)

        }


        buttonA.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'a')
            buttonA.isEnabled = false

        }
        buttonB.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'b')
            buttonB.isEnabled = false

        }
        buttonC.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'c')
            buttonC.isEnabled = false

        }
        buttonD.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'd')
            buttonD.isEnabled = false

        }
        buttonE.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'e')
            buttonE.isEnabled = false

        }
        buttonF.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'f')
            buttonF.isEnabled = false

        }
        buttonG.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'g')
            buttonG.isEnabled = false

        }
        buttonH.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'h')
            buttonH.isEnabled = false

        }
        buttonI.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'i')
            buttonI.isEnabled = false

        }
        buttonJ.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'j')
            buttonJ.isEnabled = false
            buttonJ.text = ""
        }
        buttonK.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'k')
            buttonK.isEnabled = false

        }
        buttonL.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'l')
            buttonL.isEnabled = false

        }
        buttonM.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'm')
            buttonM.isEnabled = false

        }
        buttonN.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'n')
            buttonN.isEnabled = false

        }
        buttonO.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'o')
            buttonO.isEnabled = false

        }
        buttonP.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'p')
            buttonP.isEnabled = false

        }
        buttonQ.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'q')
            buttonQ.isEnabled = false

        }
        buttonR.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'r')
            buttonR.isEnabled = false

        }
        buttonS.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 's')
            buttonS.isEnabled = false

        }
        buttonT.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 't')
            buttonT.isEnabled = false

        }
        buttonU.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'u')
            buttonU.isEnabled = false

        }
        buttonV.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'v')
            buttonV.isEnabled = false

        }
        buttonW.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'w')
            buttonW.isEnabled = false

        }
        buttonX.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'x')
            buttonX.isEnabled = false

        }
        buttonY.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'y')
            buttonY.isEnabled = false

        }
        buttonZ.setOnClickListener {
            masukkanHuruf(soal, arrayJawaban, 'z')
            buttonZ.isEnabled = false
        }
    }

    fun masukkanHuruf(word: String, enteredLetters: CharArray, userInput : Char){

        val emptyPosition = findEmptyPosition(enteredLetters)

        if (word.contains(userInput.toString())) {
            enteredLetters[emptyPosition] = userInput
            printWord(word, enteredLetters)
            if (!txtJawaban.text.contains("_"))
            {
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("status" , "menang")
                intent.putExtra("player_name" , hangman.playerName)
                intent.putExtra("jumlah_salah" , jumlahSalah)
                startActivity(intent)
                finish()
            }
        } else {
//            Toast.makeText(this, userInput + " is not in the word", Toast.LENGTH_LONG ).show()
            if (hangman.image == true)
            {
                if (jumlahSalah==11)
                {
                    imgHangman.setImageResource(g11)
                } else if (jumlahSalah == 10) {
                    imgHangman.setImageResource(g10)
                } else if (jumlahSalah == 9) {
                    imgHangman.setImageResource(g9)
                } else if (jumlahSalah == 8) {
                    imgHangman.setImageResource(g8)
                } else if (jumlahSalah == 7) {
                    imgHangman.setImageResource(g7)
                } else if (jumlahSalah == 6) {
                    imgHangman.setImageResource(g6)
                } else if (jumlahSalah == 5) {
                    imgHangman.setImageResource(g5)
                } else if (jumlahSalah == 4) {
                    imgHangman.setImageResource(g4)
                } else if (jumlahSalah == 3) {
                    imgHangman.setImageResource(g3)
                } else if (jumlahSalah == 2) {
                    imgHangman.setImageResource(g2)
                } else if (jumlahSalah == 1) {
                    imgHangman.setImageResource(g1)
                }
            }
            jumlahSalah++
            if (jumlahSalah >= 11)
            {
                var intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("status" , "kalah")
                intent.putExtra("player_name" , player_name)
                intent.putExtra("jumlah_salah" , jumlahSalah)
                startActivity(intent)
                finish()
            }
        }
    }


//CETAK JAWABAN DIGARIS
    fun printWord(soal: String, arrayJawaban: CharArray){
        // Iterate through all letters in word
        txtJawaban.text = ""
        for (i in 0 until soal.length) {
            val letter = soal[i]
            if (inEnteredLetters(letter, arrayJawaban))
                txtJawaban.text = txtJawaban.text.toString() + letter
            else {
                txtJawaban.text = txtJawaban.text.toString() + "_"
            }
        }
    }


    fun countLetter(character :  String):Int{
        var count = 0
        var splitJawaban = txtJawaban.text.toString().split(" _").toTypedArray()
        for(i in 0 until splitJawaban.size){
            if(splitJawaban[i].equals(character))
            {
                count++
            }
        }

        return count;
    }






    /* Check if letter is in arrayJawaban array */
    fun inEnteredLetters(soal: Char, arrayJawaban: CharArray): Boolean {
        return String(arrayJawaban).contains(soal.toString())
    }

    /* Find first empty position in array of entered letters (one with code \u0000) */
    fun findEmptyPosition(enteredLetters: CharArray): Int {
        var i = 0
        while (enteredLetters[i] != '\u0000') i++
        return i
    }
}
