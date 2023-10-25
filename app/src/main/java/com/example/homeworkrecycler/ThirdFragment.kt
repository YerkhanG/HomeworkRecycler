package com.example.homeworkrecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.homeworkrecycler.databinding.FragmentSecondBinding
import com.example.homeworkrecycler.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private lateinit var binding : FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = ThirdFragmentArgs.fromBundle(requireArguments())
        val itemName = args.name
        binding = FragmentThirdBinding.inflate(inflater , container, false)
        binding.text.text = itemName
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.mainButton.setOnClickListener{
//            navigate(SecondFragment().javaClass)
//        }
    }
}