package com.kai.capstone_rapidresq.ui.profiles

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kai.capstone_rapidresq.R
import com.kai.capstone_rapidresq.data.local.DummyDataUser
import com.kai.capstone_rapidresq.data.local.DummyUser
import com.kai.capstone_rapidresq.databinding.FragmentProfileBinding
import com.kai.capstone_rapidresq.ui.add.updateProfile.UpdateProfileDataActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
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

        val user: DummyUser = DummyDataUser.userList[1]

        binding.tvName.text = "${user.nama}"
        binding.tvAddress.text = "Alamat: ${user.address}"
        binding.tvEmail.text = "Email: ${user.email}"
        binding.tvGender.text = "Gender: ${user.gender}"
        binding.tvBpjs.text = "No BPJS: ${user.bpjs}"
        binding.tvKtp.text = "No KTP: ${user.ktp}"
        binding.tvBirthDate.text = "Tanggal Lahir: ${user.birthDate}"
        binding.tvPhoneNumber.text = "No Telepon: ${user.phoneNumber}"
        binding.tvWork.text = "Pekerjaan: ${user.job}"
        Glide.with(requireContext()).load(user.profilePhoto).placeholder(R.drawable.ic_baseline_person_24).into(binding.ivProfile)

        binding.btnUpdate.setOnClickListener {
            val intent = Intent(requireContext(), UpdateProfileDataActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}