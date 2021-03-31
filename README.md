# Password-Analyser-and-Generator

A simple password analyser and generator application using kotlin.

### Password Analyzer.

## Usage


Create `Passwordchecker` enum class for Checking password strength(weak,medium,strong and very strong).

import `Passwordchecker` to Main class

```

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

```
![passwordanalyser](https://user-images.githubusercontent.com/71749797/113116497-21029b00-922b-11eb-9f2a-d4f6a225a8c1.gif)
### Password Generator.

## Usage


Create  and import `PasswordCreator`  class for Creating a strong password.
```
    lateinit var passwordCreator: PasswordCreator
    passwordCreator = PasswordCreator()

```
Use PasswordCreator to create password.



```
      val createdpassword: String =
                passwordCreator.generatePassword(true, true, true, false, 17)

```
![passwordgenerator](https://user-images.githubusercontent.com/71749797/113116148-cc5f2000-922a-11eb-8daa-7740d29d0b9f.gif)
### Author



Nithin Thomas. 
