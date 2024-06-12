package com.example.easybridal_partner

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LanguageActivity : AppCompatActivity() {

    private var selectedButton: RelativeLayout? = null
    private var selectedArrow: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }

        val englishButton: RelativeLayout = findViewById(R.id.english_language)
        val arrowEnglish: ImageView = findViewById(R.id.arrow_english)

        val indonesiaButton: RelativeLayout = findViewById(R.id.indonesia_language)
        val arrowIndonesia: ImageView = findViewById(R.id.arrow_indonesia)

        setLanguageSelection(englishButton, arrowEnglish)
        setLanguageSelection(indonesiaButton, arrowIndonesia)

        // Set default language to English
        selectDefaultLanguage(englishButton, arrowEnglish)
    }

    private fun setLanguageSelection(button: RelativeLayout, arrow: ImageView) {
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

    private fun selectDefaultLanguage(button: RelativeLayout, arrow: ImageView) {
        resetSelectedLanguage()
        button.background = getSelectedOutlineDrawable()
        arrow.visibility = View.VISIBLE
        selectedButton = button
        selectedArrow = arrow
    }

    private fun resetSelectedLanguage() {
        selectedButton?.background = getNormalOutlineDrawable()
        selectedArrow?.visibility = View.GONE
        selectedButton = null
        selectedArrow = null
    }

    private fun animateButton(button: RelativeLayout) {
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
