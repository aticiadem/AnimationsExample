package com.example.animasyonlar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import com.example.animasyonlar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var fabState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // buttonTranslationAnimation()
        // textTranslationAnimation()
        // imageTranslationAnimation()

        binding.button.setOnClickListener {
            // alphaAnimation()
            // scaleAnimation()
            // rotateAnimation()
            // translationAnimation()
            // delayAnimation()
            // accelerateAnimation()
            // repeatAnimation()
            // multipleTogetherAnimation()
            // multipleSequentiallyAnimation()
            val intent = Intent(this,MotionActivity::class.java)
            startActivity(intent)
        }

    }

    private fun alphaAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"alpha",1.0f,0.0f).apply {
            duration = 1500
        }
        objAnimator.start()
    }

    // scaleX -> horizontal , scaleY -> vertical
    private fun scaleAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"scaleX",1.0f,2.0f).apply {
            duration = 1500
        }
        objAnimator.start()
    }

    private fun rotateAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.textView,"rotation",0.0f,90.0f).apply {
            duration = 2000
        }
        objAnimator.start()
    }

    // translationX -> horizontal , translationY -> vertical
    private fun translationAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.textView,"translationY",0.0f,80.0f).apply {
            duration = 1500
        }
        objAnimator.start()
    }

    private fun buttonTranslationAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.button,"translationY",900.0f,0.0f).apply {
            duration = 1000
        }
        objAnimator.start()
    }

    private fun textTranslationAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.textView,"translationX",900.0f,0.0f).apply {
            duration = 1000
        }
        objAnimator.start()
    }

    private fun imageTranslationAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"translationX",-900.0f,0.0f).apply {
            duration = 1000
        }
        objAnimator.start()
    }

    // waits for 2 seconds and then starts
    private fun delayAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"translationY",0.0f,100.0f).apply {
            duration = 1000
            startDelay = 2000
        }
        objAnimator.start()
    }

    private fun accelerateAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"translationX",0.0f,200.0f).apply {
            duration = 1000
            // interpolator = OvershootInterpolator()
            interpolator = BounceInterpolator()
        }
        objAnimator.start()
    }

    private fun repeatAnimation(){
        val objAnimator = ObjectAnimator.ofFloat(binding.imageView,"translationY",0.0f,200.0f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            //repeatMode = ObjectAnimator.RESTART
            repeatMode = ObjectAnimator.REVERSE
        }
        objAnimator.start()
    }

    private fun multipleTogetherAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.imageView,"alpha",1.0f,0.0f)
        val scaleX = ObjectAnimator.ofFloat(binding.imageView,"scaleX",1.0f,2.0f)
        val scaleY = ObjectAnimator.ofFloat(binding.imageView,"scaleY",1.0f,3.0f)

        val objAnimator = AnimatorSet().apply {
            duration = 1000
            playTogether(alpha,scaleX,scaleY)
        }
        objAnimator.start()
    }

    private fun multipleSequentiallyAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.imageView,"alpha",1.0f,0.0f)
        val scaleX = ObjectAnimator.ofFloat(binding.imageView,"scaleX",1.0f,2.0f)
        val scaleY = ObjectAnimator.ofFloat(binding.imageView,"scaleY",1.0f,3.0f)

        val objAnimator = AnimatorSet().apply {
            duration = 1000
            playSequentially(scaleX,scaleY,alpha)
        }
        objAnimator.start()
    }

}