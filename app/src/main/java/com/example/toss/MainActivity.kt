package com.example.toss

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coin.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {

                //hideCoin fun is called
                hideCoin()

                //randomNumber fun is called to get random number
                randomNumber()

            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })


    }

    // fun to handle all the views when animation starts
    private fun showCoin(){
        coin.visibility = View.VISIBLE
        textView.visibility = View.GONE
        button.isEnabled = false
    }

    // fun to handle all the views when animation ends
    private fun hideCoin(){
        coin.visibility =View.GONE
        textView.visibility = View.VISIBLE
        button.isEnabled =true
    }

    // this is called when button is clicked
    fun flipCoin(view : View){

        // fun showCoin is called
        showCoin()
        // fun to start animation
        coin.playAnimation()
    }

    // fun to get random Number and display result accordingly
    fun randomNumber(){

        // to get random number
        val random = (1..2).random()

        // to display heads or tails
        if(random == 1){
            textView.text = getString(R.string.heads_outcome)
        }
        else{
            textView.text  = getString(R.string.tails_outcome)
        }
    }
}