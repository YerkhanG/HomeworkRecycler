package com.example.homeworkrecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkrecycler.databinding.FragmentMainBinding
import com.example.homeworkrecycler.databinding.FragmentSecondBinding

class SecondFragment : Fragment(){
    private lateinit var binding : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.mainButton.setOnClickListener{
//            navigate(SecondFragment().javaClass)
//        }
    }
}