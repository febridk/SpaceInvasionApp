package id.febridk.spaceinvasion.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.febridk.spaceinvasion.R
import id.febridk.spaceinvasion.databinding.ActivityMainBinding
import id.febridk.spaceinvasion.ui.auth.AuthActivity
import id.febridk.spaceinvasion.ui.auth.SpaceInvasionAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener{
            SpaceInvasionAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}