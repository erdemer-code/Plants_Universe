package com.ozu.cs394.plantsuniverse.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozu.cs394.plantsuniverse.databinding.DetailFragmentBinding


import androidx.databinding.DataBindingUtil


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
        viewModel.getPlant(requireContext(),args.id)
        initObserver()


    }

    private fun initObserver() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            if (it){
                binding.apply {
                    pbDetailLoading.visibility = View.INVISIBLE
                    clDetailMainBox.visibility = View.VISIBLE
                }
            }
        }


        viewModel.getPlantLiveData.observe(viewLifecycleOwner){
            binding.plant = it
        }

    }



}