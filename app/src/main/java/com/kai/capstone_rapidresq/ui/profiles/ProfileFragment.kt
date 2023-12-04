package com.kai.capstone_rapidresq.ui.profiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kai.capstone_rapidresq.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Contoh data profil
        val userName = "kai"
        val userEmail = "kai.doe@example.com"
        val address = "Yogya"
        val bDay = "march 29"
        val number = "911"

        // Set data profil ke tampilan
//        binding.tvName.text = userName
//        binding.tvEmail.text = userEmail
//        binding.tvAddress.text = address
//        binding.tvBirthDate.text = bDay
//        binding.tvPhoneNumber.text = number
//        binding.btnUpdate.setOnClickListener {
//            showToast("button clicked")
//        }
    }

    private fun showToast(message: String) {
        // Membuat dan menampilkan Toast dengan pesan yang diberikan
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}