package com.example.a1_witview.ui.firebase

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1_witview.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fb_signup.*

class SignUp : AppCompatActivity(){

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fb_signup)

        mAuth = FirebaseAuth.getInstance()

        signin_button_SU.setOnClickListener{
            startActivity(Intent (this, SignIn::class.java ))
            finish()
        }

        signup_button.setOnClickListener {
            signUpUser()
        }



    }

    fun updateUI(currentUser: FirebaseUser?){


    }

    private fun signUpUser() {
        //Error handling
        if (signup_email.text.toString().isEmpty()) {
            signup_email.error = "Please enter email"
            signup_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(signup_email.text.toString()).matches()) {
            signup_email.error = "Please enter valid email"
            signup_email.requestFocus()
            return
        }

        if (signup_password.text.toString().isEmpty()) {
            signup_password.error = "Please enter password"
            signup_password.requestFocus()
            return
        }
        //

        mAuth.createUserWithEmailAndPassword(signup_email.text.toString(), signup_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = mAuth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this,SignIn::class.java))
                                finish()
                            }
                        }

                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}