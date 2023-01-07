package com.demo.country.ui.list

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.R
import com.demo.country.domain.Country
import com.demo.country.domain.RequestStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as CountryListAdaptor
    adapter.submitList(data)
}

@BindingAdapter("requestStatus")
fun bindStatus(statusImageView: ImageView, status: RequestStatus?) {
    when (status) {
        RequestStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        RequestStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}
