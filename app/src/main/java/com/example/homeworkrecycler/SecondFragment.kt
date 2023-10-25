package com.example.homeworkrecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.homeworkrecycler.databinding.FragmentMainBinding
import com.example.homeworkrecycler.databinding.FragmentSecondBinding
import com.example.homeworkrecycler.decoration.BaseFragment
import com.example.homeworkrecycler.decoration.HeaderDecoration
import com.example.homeworkrecycler.decoration.JobsListAdapter
import com.example.homeworkrecycler.decoration.JobsListDto
import com.example.homeworkrecycler.decoration.JobsListMaker
import com.example.homeworkrecycler.decoration.JobsListType
import com.example.homeworkrecycler.decoration.OffsetDecoration
import com.example.homeworkrecycler.decoration.SpecListMaker

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate){
    override fun onBindView() {
        super.onBindView()
        val adapter = JobsListAdapter(getTransformedList())
        binding.listView.adapter = adapter
        binding.listView.addItemDecoration(OffsetDecoration(8,4,4,16))
        binding.listView.addItemDecoration(HeaderDecoration())
        binding.listView.layoutManager = LinearLayoutManager(this.context)
        adapter.itemClick = {
            findNavController().navigate(
                SecondFragmentDirections
                    .actionSecondFragmentToThird(it.toString())
            )
        }
        LinearSnapHelper().attachToRecyclerView(binding.listView)
    }
    private fun getTransformedList(): List<JobsListDto> {
        val jobsList = JobsListMaker.getJobsList(this.context)
        val specList = SpecListMaker.getSpecList(this.context)
        val list: MutableList<JobsListDto> = mutableListOf()
        var cnt = 0
        jobsList.forEachIndexed { index, item ->
            if (index % 2 == 0) {
                list.add(JobsListDto(JobsListType.SPECS_VIEW, specList[cnt]))
                list.add(JobsListDto(JobsListType.JOBS_VIEW, item))
                cnt++
            } else {
                list.add(JobsListDto(JobsListType.JOBS_VIEW, item))
            }

        }
        list.add(JobsListDto(JobsListType.SPACING_VIEW, ""))
        return list
    }
//    private fun getTransformedList(): List<JobsListDto> {
//        val jobsList = JobsListMaker.getJobsList(this.context)
//        val list: MutableList<JobsListDto> = mutableListOf()
//        jobsList.forEachIndexed { index, item ->
//            val previousItem = if (index > 0) jobsList[index - 1] else null
//
//            if (previousItem?.firstOrNull()?.lowercase() != item.firstOrNull()?.lowercase()) {
//                list.add(JobsListDto(JobsListType.SPECS_VIEW, item.firstOrNull().toString()))
//            }
//            list.add(JobsListDto(JobsListType.JOBS_VIEW, item))
//        }
//        list.add(JobsListDto(JobsListType.SPACING_VIEW, ""))
//        return list
//    }

}