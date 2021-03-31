package com.example.passwordchecker

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var password: EditText
    lateinit var status: TextView
    lateinit var main_linear: LinearLayout
    lateinit var status_img: ImageView
    lateinit var genrate_password: Button
    lateinit var passwordCreator: PasswordCreator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        password = findViewById(R.id.password)
        status = findViewById(R.id.status)
        main_linear = findViewById(R.id.main_linear)
        status_img = findViewById(R.id.status_img)
        genrate_password = findViewById(R.id.genrate_password)
        passwordCreator = PasswordCreator()

        password.addTextChangedListener(textWatcher)

        genrate_password.setOnClickListener {
            val createdpassword: String =
                passwordCreator.generatePassword(true, true, true, false, 17)
            password.setText(createdpassword, TextView.BufferType.EDITABLE);
        }

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        @SuppressLint("ResourceAsColor")
        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (text?.isNotEmpty()!!) {
                checkpassword(text.toString())
                status.visibility = View.VISIBLE
                status_img.visibility = View.VISIBLE

            } else {
                status.visibility = View.INVISIBLE
                status_img.visibility = View.INVISIBLE
                main_linear.setBackgroundColor(R.color.teal_200)

            }

        }

    }

    @SuppressLint("ResourceAsColor")
    private fun checkpassword(toString: String) {

        val passwordlength = password.text.toString()
        if (passwordlength.isNotEmpty()) {
            val passwordStrength: Passwordchecker = Passwordchecker.calculate(toString)
            status.text = passwordStrength.msg
            main_linear.setBackgroundColor(passwordStrength.color)
            status_img.setImageResource(passwordStrength.img)
        } else {
            main_linear.setBackgroundColor(R.color.teal_200)
        }

    }
}


