package com.example.homeworkrecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homeworkrecycler.databinding.FragmentMainBinding
import com.example.homeworkrecycler.databinding.FragmentSecondBinding
import com.example.homeworkrecycler.decoration.BaseFragment


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    //    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentMainBinding.inflate(inflater , container, false)
//        return binding.root
//    }
    override fun onBindView() {
        super.onBindView()
        binding.mainButton.setOnClickListener() {
            // navigate(SecondFragment().javaClass)
            findNavController().navigate(
                MainFragmentDirections
                    .actionMainFragmentToSecondFragment()
            )
        }
    }

}