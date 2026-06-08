package com.example.gymflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager

    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            try {
                val account = task.getResult(ApiException::class.java)

                val credential = GoogleAuthProvider.getCredential(
                    account.idToken,
                    null
                )

                auth.signInWithCredential(credential)
                    .addOnCompleteListener { authTask ->

                        if (authTask.isSuccessful) {

                            startActivity(
                                Intent(
                                    this,
                                    HomeActivity::class.java
                                )
                            )
                            finish()

                        } else {

                            Toast.makeText(
                                this,
                                getString(R.string.google_login_failed),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

            } catch (e: Exception) {

                Toast.makeText(
                    this,
                    e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(application)

        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()


        val email = findViewById<EditText>(R.id.emailEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerScreenButton)
        val guestButton = findViewById<Button>(R.id.guestButton)
        val googleButton = findViewById<Button>(R.id.googleLoginButton)
        val facebookButton = findViewById<Button>(R.id.facebookLoginButton)

        // FACEBOOK CALLBACK
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult) {

                    val credential =
                        FacebookAuthProvider.getCredential(
                            result.accessToken.token
                        )

                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {

                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        HomeActivity::class.java
                                    )
                                )

                                finish()
                            }
                        }
                }

                override fun onCancel() {}

                override fun onError(error: FacebookException) {

                    Toast.makeText(
                        this@LoginActivity,
                        error.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        )

        // EMAIL LOGIN
        loginButton.setOnClickListener {

            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString().trim()

            if (userEmail.isEmpty() || userPassword.isEmpty()) {

                Toast.makeText(
                    this,
                    getString(R.string.fill_all_fields),
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(
                userEmail,
                userPassword
            ).addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    startActivity(
                        Intent(
                            this,
                            HomeActivity::class.java
                        )
                    )

                    finish()

                } else {

                    Toast.makeText(
                        this,
                        task.exception?.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        // REGISTER
        registerButton.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )
        }

        // GUEST
        guestButton.setOnClickListener {

            auth.signInAnonymously()
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        startActivity(
                            Intent(
                                this,
                                HomeActivity::class.java
                            )
                        )

                        finish()

                    } else {

                        Toast.makeText(
                            this,
                            getString(R.string.guest_login_failed),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        // GOOGLE
        googleButton.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
            )
                .requestIdToken(
                    getString(R.string.default_web_client_id)
                )
                .requestEmail()
                .build()

            val googleSignInClient =
                GoogleSignIn.getClient(this, gso)

            googleSignInLauncher.launch(
                googleSignInClient.signInIntent
            )
        }

        // FACEBOOK
        facebookButton.setOnClickListener {

            LoginManager.getInstance()
                .logInWithReadPermissions(
                    this,
                    listOf("email", "public_profile")
                )
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        callbackManager.onActivityResult(
            requestCode,
            resultCode,
            data
        )
    }
}