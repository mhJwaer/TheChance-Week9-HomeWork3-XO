package com.example.thechanceweek9homework3xo

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.thechanceweek9homework3xo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private var flag: Boolean = true

    @SuppressLint("NewApi")
    fun btnClick(view: View) {
        val btn = view as Button
        if (btn.text == "X" || btn.text == "O") return
        if (flag) {
            btn.text = "X"
            btn.setTextColor(getColor(R.color.xcolor))
            winLogic()
        } else {
            btn.text = "O"
            btn.setTextColor(getColor(R.color.ocolor))
            winLogic()
        }
        btn.isEnabled = false
        flag = !flag
    }

    private fun winLogic() {
        //first row

        if ( binding.btn1.text == binding.btn2.text && binding.btn2.text == binding.btn3.text && !binding.btn1.isEnabled ) {
            winner()
            return
        }
        //mid row
        if ( binding.btn4.text == binding.btn5.text && binding.btn5.text == binding.btn6.text && !binding.btn4.isEnabled) {
            winner()
            return
        }
        //last row
        if (binding.btn7.text == binding.btn8.text && binding.btn8.text == binding.btn9.text && !binding.btn7.isEnabled) {
            winner()
            return
        }
        //first column
        if (binding.btn1.text == binding.btn4.text && binding.btn4.text == binding.btn7.text && !binding.btn1.isEnabled ) {
            winner()
            return
        }
        //mid column
        if (binding.btn2.text == binding.btn5.text && binding.btn5.text == binding.btn8.text && !binding.btn2.isEnabled) {
            winner()
            return
        }
        //last column
        if (binding.btn3.text == binding.btn6.text && binding.btn6.text == binding.btn9.text && !binding.btn3.isEnabled) {
            winner()
            return
        }
        //diagonal
        if (binding.btn1.text == binding.btn5.text && binding.btn5.text == binding.btn9.text && !binding.btn1.isEnabled) {
            winner()
            return
        }
        //diagonal inverse
        if (binding.btn3.text == binding.btn5.text && binding.btn5.text == binding.btn7.text && !binding.btn3.isEnabled) {
            winner()
            return
        }
    }


    private fun winner() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
        builder.setTitle("Game Over")
        if (flag) {
            builder.setMessage("X is Winner")
        }
        else {
            builder.setMessage("O is Winner")
        }
        builder.setPositiveButton("New Game") { dialog, _ ->
            newGame()
            dialog.dismiss()
        }
        builder.show()
    }

    private fun newGame() {
        binding.btn1.text=""
        binding.btn1.isEnabled = true

        binding.btn2.text=""
        binding.btn2.isEnabled = true

        binding.btn3.text=""
        binding.btn3.isEnabled = true

        binding.btn4.text=""
        binding.btn4.isEnabled = true

        binding.btn5.text=""
        binding.btn5.isEnabled = true

        binding.btn6.text=""
        binding.btn6.isEnabled = true

        binding.btn7.text=""
        binding.btn7.isEnabled = true

        binding.btn8.text=""
        binding.btn8.isEnabled = true

        binding.btn9.text=""
        binding.btn9.isEnabled = true

        flag = true
    }
}