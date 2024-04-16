package com.example.icetask3studentapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LoginAcctivity : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var btnLogin : Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_acctivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        username= findViewById(R.id.usernametxt)
        password = findViewById(R.id.passwordtxt)
        btnLogin = findViewById(R.id.loginbtn)

        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener{
            login()
        }
    }
    fun login() {
        val email = username.text.toString()
        val pass = password.text.toString()
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Log In Failed", Toast.LENGTH_SHORT).show()
        }

    }
}