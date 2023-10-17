package com.example.homeworkrecycler.decoration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.homeworkrecycler.databinding.ItemJobsBinding
import com.example.homeworkrecycler.databinding.ItemSpacingBinding
import com.example.homeworkrecycler.databinding.ItemSpecsBinding

class JobsListAdapter (
    private val items: List<JobsListDto>
) : RecyclerView.Adapter<BaseJobsViewHolder<*, String>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseJobsViewHolder<*, String> {
        return when (viewType) {
            JobsListType.SPECS_VIEW.ordinal -> HeaderViewHolder(
                ItemSpecsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            JobsListType.JOBS_VIEW.ordinal -> CountryViewHolder(
                ItemJobsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> SpacingViewHolder(
                ItemSpacingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), 16
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseJobsViewHolder<*, String>, position: Int) {
        holder.bindView(items[position].name)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.ordinal
    }

    class CountryViewHolder(override val binding: ItemJobsBinding) :
        BaseJobsViewHolder<ItemJobsBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.title.text = item
        }
    }

    class HeaderViewHolder(override val binding: ItemSpecsBinding) :
        BaseJobsViewHolder<ItemSpecsBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.root.text = item

            binding.root.setOnClickListener {

            }
        }
    }
}

abstract class BaseJobsViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

enum class JobsListType {
    SPECS_VIEW, JOBS_VIEW, SPACING_VIEW
}

data class JobsListDto(
    val viewType: JobsListType,
    val name: String
)