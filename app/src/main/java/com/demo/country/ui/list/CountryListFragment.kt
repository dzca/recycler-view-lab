package com.demo.country.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.databinding.FragmentCountryListBinding
import timber.log.Timber

class CountryListFragment : Fragment() {

    private val viewModel: CountryListViewModel by lazy {
        ViewModelProvider(this).get(CountryListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Timber.d("[CountryListFragment] onCreateView()")
        val binding = FragmentCountryListBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the ViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the photosGrid RecyclerView
        binding.countriesList.adapter = CountryListAdaptor()

        return binding.root
    }
}