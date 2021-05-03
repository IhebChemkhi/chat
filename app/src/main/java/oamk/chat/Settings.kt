package oamk.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Settings : AppCompatActivity() {
    private lateinit var tyEmail :TextView
    private lateinit var signout: Button
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        tyEmail=findViewById(R.id.email)
        supportActionBar?.apply{
            title="settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val currentUser= intent.getParcelableExtra<FirebaseUser>("currentUser")
        tyEmail.setText(currentUser?.email)
        signout= findViewById(R.id.signout)
        signout.setOnClickListener{
            signOut(it)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    fun signOut(view: View){
        FirebaseAuth.getInstance().signOut()
        tyEmail.setText("")
    }

}