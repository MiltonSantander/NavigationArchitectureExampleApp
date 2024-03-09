package com.example.navigationarchitectureexampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationarchitectureexampleapp.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.submitButton.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty()) {
                it.findNavController().navigate(
                    R.id.action_nameFragment_to_emailFragment,
                    bundleOf("userName" to binding.editText.text.toString())
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Por favor ingrese su nombre",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return binding.root
    }
}