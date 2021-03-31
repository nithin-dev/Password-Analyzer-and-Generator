package com.example.passwordchecker

import android.graphics.Color


enum class Passwordchecker(var msg: String, var color: Int, var img: Int) {

    WEAK("Weak", Color.parseColor("#ff0000"),R.drawable.sad), MEDIUM("Medium", Color.parseColor("#ff4c4c"),R.drawable.medium), STRONG("Strong", Color.parseColor("#00bfff"),R.drawable.happy), VERY_STRONG("Very Strong", Color.parseColor("#1e90ff"),R.drawable.veryhappy);

    companion object {
        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 15
        fun calculate(password: String): Passwordchecker {
            var score = 0
            var upper = false
            var lower = false
            var digit = false
            var specialChar = false
            for (element in password) {
                if (!specialChar && !Character.isLetterOrDigit(element)) {
                    score++
                    specialChar = true
                } else {
                    if (!digit && Character.isDigit(element)) {
                        score++
                        digit = true
                    } else {
                        if (!upper || !lower) {
                            if (Character.isUpperCase(element)) {
                                upper = true
                            } else {
                                lower = true
                            }
                            if (upper && lower) {
                                score++
                            }
                        }
                    }
                }
            }
            val length = password.length
            if (length > MAX_LENGTH) {
                score++
            } else if (length < MIN_LENGTH) {
                score = 0
            }
            when (score) {
                0 -> return WEAK
                1 -> return MEDIUM
                2 -> return STRONG
                3 -> return VERY_STRONG
                else -> {
                }
            }
            return VERY_STRONG
        }
    }

}