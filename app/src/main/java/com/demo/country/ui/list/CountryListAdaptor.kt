package com.demo.country.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.country.databinding.CountryViewItemBinding
import com.demo.country.domain.Country

class CountryListAdaptor:
    ListAdapter<Country, CountryListAdaptor.CountryViewHolder>(DiffCallback)  {

    class CountryViewHolder(private var binding: CountryViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(country)
//        }
        holder.bind(country)
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Country]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.code == newItem.code
        }
    }
}