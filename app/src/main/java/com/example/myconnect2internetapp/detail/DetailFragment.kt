package com.example.myconnect2internetapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.myconnect2internetapp.R
import com.example.myconnect2internetapp.databinding.FragmentDetailBinding

/**
 * This [Fragment] will show the detailed information about a selected piece of Mars real estate.
 */
class DetailFragment : Fragment() {

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
    // TODO (14) Get the selectedProperty from the fragment arguments with DetailFragmentArgs
      val marsProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
    // TODO (15) Create the DetailViewModelFactory using the marsProperty and application
    val viewModelFactory = DetailViewModelFactory(marsProperty, application)
    // TODO (16) Get the DetailViewModel from the DetailViewModelFactory and set it in the binding
    binding.viewModel = ViewModelProvider(
        this, viewModelFactory).get(DetailViewModel::class.java)
        binding.setLifecycleOwner(this)
        return binding.root
    }
}
