package com.example.homeworkrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.homeworkrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit{
            replace(R.id.container , MainFragment())
        }
    }

}
fun Fragment.navigate(fragmentClass: Class<Fragment>, bundle : Bundle? = null){
    requireActivity().supportFragmentManager.commit {
        add(R.id.container,fragmentClass,bundle, fragmentClass.name)
    }
}
