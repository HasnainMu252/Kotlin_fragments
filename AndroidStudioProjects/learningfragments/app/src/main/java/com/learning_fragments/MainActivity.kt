package com.learning_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.learning_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val first = first_fragments()
        val second = second_fragment()
        val setting = setting()


        // Set default fragment
        setCurrentFragment(first)
        //
//        there is use of lamda -> use in the function
//        we first make the menu in xml then we use id to to fetch the home , and shop and setting
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.home -> setCurrentFragment(first)
                R.id.shop -> setCurrentFragment(second)
                R.id.setting -> setCurrentFragment(setting)
                else -> {
                    setCurrentFragment(first)
                }

            }
            true
        }
//
//

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FrameLayout, fragment)
            addToBackStack(null)
            commit()
        }
    }

}
