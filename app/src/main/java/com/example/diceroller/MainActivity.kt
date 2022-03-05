package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        //Создаём кубик с шестью сторонами
        val dice = Dice(6)
        //Бросаем кубик
        val diceRoll = dice.roll()
        //Указываем на место вывода результата
        val resultTextView: TextView = findViewById(R.id.textView)
        //Выводим результат на экран
        resultTextView.text = diceRoll.toString()
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