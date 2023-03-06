package com.example.curve_navigation_bar


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.curve_navigation_bar.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()
        val uid = firebaseAuth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        val database = Firebase.database
        val myRef = database.getReference("User")

        //change of view between login and registration
        binding.singUp.setOnClickListener {
            binding.singUp.background =
                ResourcesCompat.getDrawable(resources, R.drawable.switch_trcks, null)
            binding.singUp.setTextColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.white,
                    null
                )
            )
            binding.login.background = null
            binding.singUpLayout.visibility = View.VISIBLE
            binding.logInLayout.visibility = View.GONE
            binding.login.setTextColor(ResourcesCompat.getColor(resources, R.color.blue, null))
        }

        //connexion LogIn
        binding.login.setOnClickListener {
            binding.singUp.background = null
            binding.singUp.setTextColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.blue,
                    null
                )
            )
            binding.login.background =
                ResourcesCompat.getDrawable(resources, R.drawable.switch_trcks, null)
            binding.singUpLayout.visibility = View.GONE
            binding.logInLayout.visibility = View.VISIBLE
            binding.login.setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))


        }

        binding.singIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}