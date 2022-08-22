package com.fruitstactoe.play

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_games.*
import java.util.*
import kotlin.math.roundToInt

class GamesActivity : AppCompatActivity() {

    private var mCountDownTimer1: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis: Long = 0
    private var mEndTime: Long = 0

    var index_win1 = 56
    var index_win2 = 58
    var index_win3 = 556
    var index_win4 = 53
    var index_win5 = 52
    var index_win6 = 57
    var index_win7 = 50
    var index_win8 = 54
    var index_win9 = 58

    var image1 = 0
    var image2 = 0
    var image3 = 0
    var image4 = 0
    var image5 = 0
    var image6 = 0
    var image7 = 0
    var image8 = 0
    var image9 = 0

    var start_timer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("fun", "")

        if(x_y == "1"){
            x()
            textView3.text = "Pomegranate’s Turn"
        }else if(x_y == "0"){
            y()
            textView3.text = "Pear’s Turn"
        }

        imageView12.setOnClickListener {
            imageView18.setImageResource(R.drawable.nulls)
            imageView19.setImageResource(R.drawable.nulls)
            imageView20.setImageResource(R.drawable.nulls)
            imageView21.setImageResource(R.drawable.nulls)
            imageView22.setImageResource(R.drawable.nulls)
            imageView23.setImageResource(R.drawable.nulls)
            imageView24.setImageResource(R.drawable.nulls)
            imageView25.setImageResource(R.drawable.nulls)
            imageView26.setImageResource(R.drawable.nulls)

            if(x_y == "1"){
                x()
                textView3.text = "Pomegranate’s Turn"
            }else if(x_y == "0"){
                y()
                textView3.text = "Pear’s Turn"
            }

            image1 = 0
            image2 = 0
            image3 = 0
            image4 = 0
            image5 = 0
            image6 = 0
            image7 = 0
            image8 = 0
            image9 = 0

            index_win1 = 56
            index_win2 = 58
            index_win3 = 556
            index_win4 = 53
            index_win5 = 52
            index_win6 = 57
            index_win7 = 50
            index_win8 = 54
            index_win9 = 58

            resetTimer()

            imageView16.visibility = View.GONE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.GONE
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putString("x_y", "0").apply()
        }

        imageView13.setOnClickListener {
            imageView18.setImageResource(R.drawable.nulls)
            imageView19.setImageResource(R.drawable.nulls)
            imageView20.setImageResource(R.drawable.nulls)
            imageView21.setImageResource(R.drawable.nulls)
            imageView22.setImageResource(R.drawable.nulls)
            imageView23.setImageResource(R.drawable.nulls)
            imageView24.setImageResource(R.drawable.nulls)
            imageView25.setImageResource(R.drawable.nulls)
            imageView26.setImageResource(R.drawable.nulls)
            if(x_y == "1"){
                x()
                textView3.text = "Pomegranate’s Turn"
            }else if(x_y == "0"){
                y()
                textView3.text = "Pear’s Turn"
            }

            image1 = 0
            image2 = 0
            image3 = 0
            image4 = 0
            image5 = 0
            image6 = 0
            image7 = 0
            image8 = 0
            image9 = 0

            index_win1 = 56
            index_win2 = 58
            index_win3 = 556
            index_win4 = 53
            index_win5 = 52
            index_win6 = 57
            index_win7 = 50
            index_win8 = 54
            index_win9 = 58

            resetTimer()

            imageView16.visibility = View.GONE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.GONE
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putString("x_y", "0").apply()
        }
    }

    fun x(){

        var index = 0

        imageView18.setOnClickListener {
            if(image1 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }

                index++
                image1 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView18.setImageResource(R.drawable.pear)
                    index_win1 = 1
                    imageView18.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView18.setImageResource(R.drawable.pomegranate)
                    index_win1 = 0
                    imageView18.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView19.setOnClickListener {
            if(image2 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image2 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView19.setImageResource(R.drawable.pear)
                    index_win2 = 1
                    imageView19.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView19.setImageResource(R.drawable.pomegranate)
                    index_win2 = 0
                    imageView19.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView20.setOnClickListener {
            if(image3 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image3 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView20.setImageResource(R.drawable.pear)
                    index_win3 = 1
                    imageView20.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView20.setImageResource(R.drawable.pomegranate)
                    index_win3 = 0
                    imageView20.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView21.setOnClickListener {
            if(image4 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image4 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView21.setImageResource(R.drawable.pear)
                    index_win4 = 1
                    imageView21.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView21.setImageResource(R.drawable.pomegranate)
                    index_win4 = 0
                    imageView21.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView22.setOnClickListener {
            if(image5 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image5 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView22.setImageResource(R.drawable.pear)
                    index_win5 = 1
                    imageView22.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView22.setImageResource(R.drawable.pomegranate)
                    index_win5 = 0
                    imageView22.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView23.setOnClickListener {
            if(image6 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image6 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView23.setImageResource(R.drawable.pear)
                    index_win6 = 1
                    imageView23.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView23.setImageResource(R.drawable.pomegranate)
                    index_win6 = 0
                    imageView23.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView24.setOnClickListener {
            if(image7 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image7 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView24.setImageResource(R.drawable.pear)
                    index_win7 = 1
                    imageView24.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView24.setImageResource(R.drawable.pomegranate)
                    index_win7 = 0
                    imageView24.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView25.setOnClickListener {
            if(image8 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image8 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView25.setImageResource(R.drawable.pear)
                    index_win8 = 1
                    imageView25.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView25.setImageResource(R.drawable.pomegranate)
                    index_win8 = 0
                    imageView25.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView26.setOnClickListener {
            if(image9 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image9 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView26.setImageResource(R.drawable.pear)
                    index_win9 = 1
                    imageView26.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pear’s Turn"
                    imageView26.setImageResource(R.drawable.pomegranate)
                    index_win9 = 0
                    imageView26.visibility = View.VISIBLE
                }
                index(index)
            }
        }
    }


    // y
    fun y(){


        var index = 0


        imageView18.setOnClickListener {
            if(image1 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image1 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView18.setImageResource(R.drawable.pomegranate)
                    index_win1 = 0
                    imageView18.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView18.setImageResource(R.drawable.pear)
                    index_win1 = 1
                    imageView18.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView19.setOnClickListener {
            if(image2 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image2 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView19.setImageResource(R.drawable.pomegranate)
                    index_win2 = 0
                    imageView19.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView19.setImageResource(R.drawable.pear)
                    index_win2 = 1
                    imageView19.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView20.setOnClickListener {
            if(image3 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image3 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView20.setImageResource(R.drawable.pomegranate)
                    index_win3 = 0
                    imageView20.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView20.setImageResource(R.drawable.pear)
                    index_win3 = 1
                    imageView20.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView21.setOnClickListener {
            if(image4 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image4 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView21.setImageResource(R.drawable.pomegranate)
                    index_win4 = 0
                    imageView21.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView21.setImageResource(R.drawable.pear)
                    index_win4 = 1
                    imageView21.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView22.setOnClickListener {
            if(image5 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image5 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView22.setImageResource(R.drawable.pomegranate)
                    index_win5 = 0
                    imageView22.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView22.setImageResource(R.drawable.pear)
                    index_win5 = 1
                    imageView22.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView23.setOnClickListener {
            if(image6 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image6 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView23.setImageResource(R.drawable.pomegranate)
                    index_win6 = 0
                    imageView23.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView23.setImageResource(R.drawable.pear)
                    index_win6 = 1
                    imageView23.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView24.setOnClickListener {
            if(image7 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image7 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView24.setImageResource(R.drawable.pomegranate)
                    index_win7 = 0
                    imageView24.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView24.setImageResource(R.drawable.pear)
                    index_win7 = 1
                    imageView24.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView25.setOnClickListener {
            if(image8 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image8 = 1
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView25.setImageResource(R.drawable.pomegranate)
                    index_win8 = 0
                    imageView25.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView25.setImageResource(R.drawable.pear)
                    index_win8 = 1
                    imageView25.visibility = View.VISIBLE
                }
                index(index)
            }
        }

        imageView26.setOnClickListener {
            if(image9 == 0) {
                if(start_timer == 1){

                }else{
                    startTimer()
                    start_timer = 1
                }
                index++
                image9 = 1
                
                val x_y = PreferenceManager.getDefaultSharedPreferences(this).getString("x_y", "0")
                if (x_y == "0") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "1").apply()
                    textView3.text = "Pear’s Turn"
                    imageView26.setImageResource(R.drawable.pomegranate)
                    index_win9 = 0
                    imageView26.visibility = View.VISIBLE
                } else if (x_y == "1") {
                    PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putString("x_y", "0").apply()
                    textView3.text = "Pomegranate’s Turn"
                    imageView26.setImageResource(R.drawable.pear)
                    index_win9 = 1
                    imageView26.visibility = View.VISIBLE
                }
                index(index)
            }
        }
    }

    fun index(index: Int){

            if (index_win1 == index_win2 && index_win3 == index_win1){

                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE
                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1

                resetTimer()
                if(index_win1 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win1 == 1){
                    textView4.text = "Pear Wins!"
                }

            }
            else if(index_win4 == index_win5 && index_win4 == index_win6){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE
                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1

                resetTimer()
                if(index_win4 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win4 == 1){
                    textView4.text = "Pear Wins!"
                }

            }
            else if(index_win7 == index_win8 && index_win7 == index_win9){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE
                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1

                resetTimer()
                if(index_win7 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win7 == 1){
                    textView4.text = "Pear Wins!"
                }

            }
            else if(index_win1 == index_win4 && index_win1 == index_win7){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE

                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                resetTimer()
                if(index_win1 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win1 == 1){
                    textView4.text = "Pear Wins!"
                }
            }
            else if(index_win2 == index_win5 && index_win2 == index_win8){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE

                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                resetTimer()
                if(index_win2 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win2 == 1){
                    textView4.text = "Pear Wins!"
                }
            }
            else if(index_win3 == index_win6 && index_win3 == index_win9){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE

                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                resetTimer()
                if(index_win3 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win3 == 1){
                    textView4.text = "Pear Wins!"
                }
            }
            else if(index_win1 == index_win5 && index_win1 == index_win9){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE

                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                resetTimer()
                if(index_win1 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win1 == 1){
                    textView4.text = "Pear Wins!"
                }
            }
            else if(index_win3 == index_win5 && index_win3 == index_win7){
                imageView16.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                textView3.visibility = View.INVISIBLE

                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                resetTimer()
                if(index_win3 == 0){
                    textView4.text = "Pomegranate Wins!"
                }
                else if(index_win3 == 1){
                    textView4.text = "Pear Wins!"
                }
            }
            else{
                if(index == 9) {
                    image1 = 1
                    image2 = 1
                    image3 = 1
                    image4 = 1
                    image5 = 1
                    image6 = 1
                    image7 = 1
                    image8 = 1
                    image9 = 1

                    resetTimer()
                    textView3.text = "Games Over"
                }
            }
    }

    private fun startTimer(): Boolean {
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mCountDownTimer1 = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                mTimerRunning = false
            }

        }.start()
        mTimerRunning = true

        return true
    }


    private fun pauseTimer() {
        mCountDownTimer1!!.cancel()
        mTimerRunning = false
    }

    private fun resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        updateCountDownText()
        start_timer = 0
        pauseTimer()
    }

    private fun updateCountDownText() {

            val hours = ((mTimeLeftInMillis / (1000 * 60 * 60)) % 24)
            val minutes = ((mTimeLeftInMillis / (1000 * 60)) % 60)
            val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
            val timeLeftFormatted =
                String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds)
            textView2!!.text = timeLeftFormatted

            if(seconds == 0){
                image1 = 1
                image2 = 1
                image3 = 1
                image4 = 1
                image5 = 1
                image6 = 1
                image7 = 1
                image8 = 1
                image9 = 1
                textView3.text = "Games Over"
            }

    }

    companion object {
        private var START_TIME_IN_MILLIS: Long = 30000
    }

    override fun onBackPressed() {
        super.onBackPressed()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putString("x_y", "0").apply()
    }

    override fun onStop() {
        super.onStop()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putString("x_y", "0").apply()
    }
}