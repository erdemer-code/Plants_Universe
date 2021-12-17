package com.ozu.cs394.plantsuniverse.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozu.cs394.plantsuniverse.R
import com.ozu.cs394.plantsuniverse.databinding.DetailFragmentBinding
import com.ozu.cs394.plantsuniverse.databinding.HomeFragmentBinding


import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ozu.cs394.plantsuniverse.room.PlantDatabase


class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(
            inflater,
            com.ozu.cs394.plantsuniverse.R.layout.detail_fragment,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        requireActivity().onBackPressedDispatcher.addCallback{
            findNavController().popBackStack()
        }
        initObserver(args.id)

    }

    private fun initObserver(id: Int) {

        PlantDatabase(requireContext()).plantDAO().getPlant(id).observe(viewLifecycleOwner){
            binding.plant = it
        }
    }



}