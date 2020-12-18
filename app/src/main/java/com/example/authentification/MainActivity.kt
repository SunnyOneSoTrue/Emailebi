package com.example.authentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmail:EditText
    private lateinit var inputPassword:EditText
    private lateinit var inputButton:Button
    private lateinit var clearButton:Button

    private lateinit var mAuthitification: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuthitification= FirebaseAuth.getInstance()
        inputEmail=findViewById(R.id.submitEmailText)
        inputPassword=findViewById((R.id.submitEmailPassword))
        inputButton=findViewById((R.id.submitButton))
        clearButton=findViewById(R.id.clearButton)


        inputButton.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "empty value detected", Toast.LENGTH_SHORT).show()
            }
            else{
                mAuthitification.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Email Successfully Stolen", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "Email Robbery Unsucessful", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        clearButton.setOnClickListener{
            inputEmail.text.clear()
            inputPassword.text.clear()


        }
    }
}