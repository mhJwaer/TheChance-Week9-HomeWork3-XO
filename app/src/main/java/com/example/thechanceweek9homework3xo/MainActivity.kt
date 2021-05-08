package com.example.thechanceweek9homework3xo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.thechanceweek9homework3xo.databinding.ActivityXoBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private var counter = 0
    fun btnClick(view: View) {
        val btn = view as Button
        var cellId = 0


        when (btn) {
            binding.btn1 -> cellId = 1
            binding.btn2 -> cellId = 2
            binding.btn3 -> cellId = 3
            binding.btn4 -> cellId = 4
            binding.btn5 -> cellId = 5
            binding.btn6 -> cellId = 6
            binding.btn7 -> cellId = 7
            binding.btn8 -> cellId = 8
            binding.btn9 -> cellId = 9
        }
        counter++
        play(cellId, btn)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    @SuppressLint("NewApi")
    private fun play(cellId: Int, selectedBtn: Button) {
        if (activePlayer == 1) {
            selectedBtn.text = "X"
            selectedBtn.setTextColor(getColor(R.color.xcolor))
            player1.add(cellId)
            activePlayer = 2
        } else {
            selectedBtn.text = "O"
            selectedBtn.setTextColor(getColor(R.color.ocolor))
            player2.add(cellId)
            activePlayer = 1
        }
        selectedBtn.isEnabled = false
        winLogic()
    }

    private fun winLogic() {
        //first row
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner(1)
            return
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner(2)
            return
        }
        //mid row
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner(1)
            return
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner(2)
            return
        }
        //last row
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner(1)
            return
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner(2)
            return
        }
        //first column
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner(1)
            return
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner(2)
            return
        }
        //mid column
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner(1)
            return
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner(2)
            return
        }
        //last column
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner(1)
            return
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner(2)
            return
        }
        //diagonal
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner(1)
            return
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner(2)
            return
        }
        //diagonal inverse
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner(1)
            return
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner(2)
            return
        }
        if (counter == 9){
            winner(-1)
        }
    }


    private fun winner(player: Int) {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
        builder.setTitle("Game Over")
        when (player) {
            1 -> builder.setMessage("X is Winner")
            2 -> builder.setMessage("O is Winner")
            else -> builder.setMessage("No On Wins")
        }

        builder.setPositiveButton("New Game") { dialog, _ ->
            newGame()
            dialog.dismiss()
        }
        builder.show()
    }

    private fun newGame() {
        //reset game values
        binding.btn1.text = ""
        binding.btn1.isEnabled = true

        binding.btn2.text = ""
        binding.btn2.isEnabled = true

        binding.btn3.text = ""
        binding.btn3.isEnabled = true

        binding.btn4.text = ""
        binding.btn4.isEnabled = true

        binding.btn5.text = ""
        binding.btn5.isEnabled = true

        binding.btn6.text = ""
        binding.btn6.isEnabled = true

        binding.btn7.text = ""
        binding.btn7.isEnabled = true

        binding.btn8.text = ""
        binding.btn8.isEnabled = true

        binding.btn9.text = ""
        binding.btn9.isEnabled = true

        activePlayer = 1
        player1.clear()
        player2.clear()
        counter = 0
    }
}