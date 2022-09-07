package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
       // do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //create a new Dice object with 6 sides and roll it
        val firstDice = Dice(6)
        val secondDice = Dice(6)
        val diceRoll1 = firstDice.roll()
        val diceRoll2 = secondDice.roll()

        //update the screen with the dice roll
        val diceImage1 : ImageView =findViewById(R.id.imageView)
        val drawableResource1=when(diceRoll1)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription=diceRoll1.toString()

        val diceImage2 : ImageView =findViewById(R.id.imageView2)
        val drawableResource2=when(diceRoll2)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription=diceRoll2.toString()

    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..6).random()
    }
}
