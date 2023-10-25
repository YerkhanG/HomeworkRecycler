package com.example.homeworkrecycler.decoration

import android.content.Context
import com.example.homeworkrecycler.R

object SpecListMaker {
    private val specList = mutableListOf(
        R.string.android , R.string.back , R.string.designer , R.string.ios , R.string.test
    )
    fun getSpecList(context: Context?): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        specList.forEach{
            if (context != null) {
                list.add(context.getString(it))
            }
        }
        list.sortBy { it.firstOrNull() }

        return list
    }
}