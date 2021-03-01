package jp.techacademy.takeshi.kataoka.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDirlog()
    }

    private fun showTimePickerDirlog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                sayAisatsu(hour)
            },
            13,0,true
        )
        timePickerDialog.show()
    }

    private fun sayAisatsu(hour: Int){
        when(hour) {
            in 2..9 -> textView1.text = "おはよう"
            in 10..17 -> textView1.text = "こんにちは"
            in 18..23, in 0..1 -> textView1.text = "こんばんは"
            else -> textView1.text = "正しい時刻を設定してください"
        }
    }
}