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
        //Создаём первый кубик с шестью сторонами
        val firstDice = Dice(6)
        //Создаём второй кубик с шестью сторонами
        val secondDice = Dice(6)
        //Бросаем кубики
        val firstDiceRoll = firstDice.roll()
        val secondDiceRoll = secondDice.roll()
        //Находим место вывода первого результата
        val resultTextView1: TextView = findViewById(R.id.textView)
        //Находиме место вывода второго результата
        val resultTextView2: TextView = findViewById(R.id.textView2)
        //Выводим результаты на экран
        resultTextView1.text = firstDiceRoll.toString()
        resultTextView2.text = secondDiceRoll.toString()
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