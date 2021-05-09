package universitas.surabaya

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var player_name = intent.getStringExtra("player_name")
        var menangataukalah = intent.getStringExtra("status");

        if(menangataukalah.equals("menang"))
        {
            var salah = intent.getIntExtra("jumlah_salah", 0)
            var score = (11-salah)*10
            txt_result.text = "SELAMAT " + player_name + " ANDA MENANG \n\n" + "ANDA MENDAPATKAN SCORE : " + score.toString()
        }
        else{
            txt_result.text = "SAYANG SEKALI " + player_name + " ANDA KALAH!"
        }
    }
}
