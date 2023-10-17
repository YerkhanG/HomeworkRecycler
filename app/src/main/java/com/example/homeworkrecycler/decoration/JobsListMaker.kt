package com.example.homeworkrecycler.decoration

import android.content.Context
import com.example.homeworkrecycler.R

class JobsListMaker {
    private val jobList = mutableListOf(
        R.string.fi, R.string.sec, R.string.thi, R.string.fo, R.string.fif, R.string.six
    )
    fun getJobsList(context: Context): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        jobList.forEach{
            list.add(context.getString(it))
        }
        list.sortBy { it.firstOrNull() }

        return list
    }
}
