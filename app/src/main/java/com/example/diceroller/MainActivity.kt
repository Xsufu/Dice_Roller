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
        //Находим ImageView кубиков
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Создаём первый кубик с шестью сторонами
        val firstDice = Dice(6)
        //Создаём второй кубик с шестью сторонами
        val secondDice = Dice(6)
        //Бросаем кубики
        val firstDiceRoll = firstDice.roll()
        val secondDiceRoll = secondDice.roll()
        //Находим место вывода первого результата

        //Находиме место вывода второго результата

        //Выводим результаты на экран

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