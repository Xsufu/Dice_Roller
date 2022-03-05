package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Данная активность позволяет пользователю
 * бросить кости и увидеть результат на экране
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим кнопку в активности
        val rollButton: Button = findViewById(R.id.button)
        //Устанавливаем прослушку нажатия и вызываем метод броска
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Бросок костей и вывод результата на экран
     */
    private fun rollDice() {
        //Находим ImageView с кубиками
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Создаём кубик с шестью сторонами
        val dice = Dice(6)
        //Бросаем кубик
        val diceRoll = dice.roll()
        //Выводим результаты на экран
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Бросок кубика
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}