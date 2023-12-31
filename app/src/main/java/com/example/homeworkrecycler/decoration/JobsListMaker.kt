package com.example.homeworkrecycler.decoration

import android.content.Context
import com.example.homeworkrecycler.R

object JobsListMaker {
    private val jobList = mutableListOf(
        R.string.fi, R.string.sec, R.string.thi, R.string.fo, R.string.fif, R.string.six, R.string.sev , R.string.eig, R.string.nin, R.string.ten
    )
    fun getJobsList(context: Context?): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        jobList.forEach{
            if (context != null) {
                list.add(context.getString(it))
            }
        }
        list.sortBy { it.firstOrNull() }

        return list
    }
}
