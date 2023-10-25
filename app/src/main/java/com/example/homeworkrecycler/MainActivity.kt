package com.example.homeworkrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.homeworkrecycler.databinding.ActivityMainBinding
import com.example.homeworkrecycler.decoration.JobsListAdapter
import com.example.homeworkrecycler.decoration.JobsListDto
import com.example.homeworkrecycler.decoration.JobsListMaker
import com.example.homeworkrecycler.decoration.JobsListType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val adapter = JobsListAdapter(getTransformedList())
        supportFragmentManager.commit {
            replace(R.id.container, MainFragment())
        }

    }
//    private fun getTransformedList(): List<JobsListDto> {
//        val jobsList = JobsListMaker.getJobsList(this)
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

    fun Fragment.navigate(fragmentClass: Class<Fragment>, bundle: Bundle? = null) {
        requireActivity().supportFragmentManager.commit {
            add(R.id.container, fragmentClass, bundle, fragmentClass.name)
        }
    }
}
