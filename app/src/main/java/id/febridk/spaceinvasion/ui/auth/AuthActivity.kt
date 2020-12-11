package id.febridk.spaceinvasion.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.febridk.spaceinvasion.R
import id.febridk.spaceinvasion.data.model.AuthUser
import id.febridk.spaceinvasion.databinding.ActivityAuthBinding
import id.febridk.spaceinvasion.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {

    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user: AuthUser?){
        val intent = Intent( this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}