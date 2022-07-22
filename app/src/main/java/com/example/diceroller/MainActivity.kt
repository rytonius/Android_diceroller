package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           /** val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
            toast.show()*/
            //rollDice()
            rollD20Dice()
        }
        // do a dice roll at open
        //rollDice()
        rollD20Dice()

    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)

        // this will load up all the images for the results
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }

        // takes the loaded resource and sets the image in the app
        diceImage.setImageResource(drawableResource)
        // this is for screen readers I guess
        diceImage.contentDescription = diceRoll.toString()

        // this is for the text on the app
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }

    private fun rollD20Dice() {
        val dice = Dice(20)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)

        // this will load up all the images for the results
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.d20_side_1
            2 -> R.drawable.d20_side_2
            3 -> R.drawable.d20_side_3
            4 -> R.drawable.d20_side_4
            5 -> R.drawable.d20_side_5
            6 -> R.drawable.d20_side_6
            7 -> R.drawable.d20_side_7
            8 -> R.drawable.d20_side_8
            9 -> R.drawable.d20_side_9
            10 -> R.drawable.d20_side_10
            11 -> R.drawable.d20_side_11
            12 -> R.drawable.d20_side_12
            13 -> R.drawable.d20_side_13
            14 -> R.drawable.d20_side_14
            15 -> R.drawable.d20_side_15
            16 -> R.drawable.d20_side_16
            17 -> R.drawable.d20_side_17
            18 -> R.drawable.d20_side_18
            19 -> R.drawable.d20_side_19
            else -> {R.drawable.d20_side_20}
        }
        
        // takes the loaded resource and sets the image in the app
        diceImage.setImageResource(drawableResource)
        // this is for screen readers I guess
        diceImage.contentDescription = diceRoll.toString()

        // this is for the text on the app
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()


    }

}

class Dice(private val Sides: Int) {
    // Roll that dice based on the side count
    fun roll(): Int {
        return (1..Sides).random()
    }
}