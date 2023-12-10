package com.kai.capstone_rapidresq.ui.profiles

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kai.capstone_rapidresq.databinding.FragmentProfileBinding
import com.kai.capstone_rapidresq.ui.add.updateProfile.UpdateProfileDataActivity

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
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnUpdate?.setOnClickListener{
            navigateToUpdateDataProfile()
        }
    }

    private fun navigateToUpdateDataProfile(){
        val intent = Intent(activity, UpdateProfileDataActivity::class.java)
        startActivity(intent)
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