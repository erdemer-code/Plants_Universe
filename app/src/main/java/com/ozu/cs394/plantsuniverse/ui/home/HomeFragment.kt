package com.ozu.cs394.plantsuniverse.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ozu.cs394.plantsuniverse.R
import com.ozu.cs394.plantsuniverse.adapter.OnPlantClickListener
import com.ozu.cs394.plantsuniverse.adapter.PlantsAdapter
import com.ozu.cs394.plantsuniverse.databinding.HomeFragmentBinding
import com.ozu.cs394.plantsuniverse.model.Plants
import com.ozu.cs394.plantsuniverse.room.PlantDatabase

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        requireActivity().onBackPressedDispatcher.addCallback{
            requireActivity().finishAffinity()
        }

        initObserver()


    }

    private fun initObserver() {
        PlantDatabase(requireContext()).plantDAO().getAllPlants().observe(viewLifecycleOwner){
            setRVAdapter(it)
        }

    }

    private fun setRVAdapter(plantsList: List<Plants>) {
        Log.e("HomeList",plantsList.toString())
        val adapter = PlantsAdapter(plantsList,object : OnPlantClickListener{
            override fun onClick(position: Int) {
                val bundle = bundleOf("id" to plantsList[position].id)
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
            }

        })
        binding.rvPlants.adapter = adapter
        binding.rvPlants.layoutManager = GridLayoutManager(requireContext(),2)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}