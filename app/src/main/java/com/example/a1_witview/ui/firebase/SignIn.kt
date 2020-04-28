package com.example.a1_witview.ui.firebase

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a1_witview.MainActivity
import com.example.a1_witview.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fb_signin.*
import kotlinx.android.synthetic.main.fb_signup.*


class SignIn : AppCompatActivity(){

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fb_signin)

        mAuth = FirebaseAuth.getInstance()

        signup_button_SI.setOnClickListener{
            startActivity(Intent (this, SignUp::class.java ))
            finish()
        }

        signin_button.setOnClickListener {
            doLogin()
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.getCurrentUser()
        updateUI(currentUser)
    }



    private fun doLogin() {

        // Error handling
        if (signin_email.text.toString().isEmpty()) {
            signin_email.error = "Please enter email"
            signin_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(signin_email.text.toString()).matches()) {
            signin_email.error = "Please enter valid email"
            signin_email.requestFocus()
            return
        }

        if (signin_password.text.toString().isEmpty()) {
            signin_password.error = "Please enter password"
            signin_password.requestFocus()
            return
        }
        //

        mAuth.signInWithEmailAndPassword(signin_email.text.toString(), signin_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                }

            }
    }

    private fun updateUI(currentUser: FirebaseUser?){

        if (currentUser != null){
            if(currentUser.isEmailVerified) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(
                    baseContext, "Please verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()

            }

        } else {
            Toast.makeText(
                baseContext, "Login failed.",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}

// https://www.youtube.com/watch?v=MA8WbvROrLs
// https://www.youtube.com/watch?v=0hkyXuKTFYY