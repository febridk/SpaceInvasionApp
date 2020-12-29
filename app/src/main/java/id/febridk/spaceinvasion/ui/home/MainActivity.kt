package id.febridk.spaceinvasion.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import id.febridk.spaceinvasion.R
import id.febridk.spaceinvasion.databinding.ActivityMainBinding
import id.febridk.spaceinvasion.ui.auth.AuthActivity
import id.febridk.spaceinvasion.ui.auth.SpaceInvasionAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_corona -> navigate(R.id.coronaFragment)
                R.id.ic_bed -> navigate(R.id.hospitalFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}