package com.example.easybridal_partner

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LanguageActivity : AppCompatActivity() {

    private var selectedButton: LinearLayout? = null
    private var selectedArrow: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        val englishButton: LinearLayout = findViewById(R.id.english_language)
        val arrowEnglish: ImageView = findViewById(R.id.arrow_english)

        val indonesiaButton: LinearLayout = findViewById(R.id.indonesia_language)
        val arrowIndonesia: ImageView = findViewById(R.id.arrow_indonesia)

        val usaButton: LinearLayout = findViewById(R.id.usa_language)
        val arrowUsa: ImageView = findViewById(R.id.arrow_usa)

        setLanguageSelection(englishButton, arrowEnglish)
        setLanguageSelection(indonesiaButton, arrowIndonesia)
        setLanguageSelection(usaButton, arrowUsa)
    }

    private fun setLanguageSelection(button: LinearLayout, arrow: ImageView) {
        button.setOnClickListener {
            if (button != selectedButton) {
                resetSelectedLanguage()
                animateButton(button)
                button.background = getSelectedOutlineDrawable()
                arrow.visibility = View.VISIBLE
                selectedButton = button
                selectedArrow = arrow
            } else {
                resetSelectedLanguage()
            }
        }
    }

    private fun resetSelectedLanguage() {
        selectedButton?.background = getNormalOutlineDrawable()
        selectedArrow?.visibility = View.GONE
        selectedButton = null
        selectedArrow = null
    }

    private fun animateButton(button: LinearLayout) {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 300
        button.startAnimation(fadeIn)
    }

    private fun getNormalOutlineDrawable(): Drawable? {
        return ContextCompat.getDrawable(this, R.drawable.outline_grey)
    }

    private fun getSelectedOutlineDrawable(): Drawable? {
        return ContextCompat.getDrawable(this, R.drawable.searchview_outline)
    }
}
