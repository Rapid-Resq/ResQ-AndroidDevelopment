package com.kai.capstone_rapidresq.ui.add

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kai.capstone_rapidresq.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private var imageUri: Uri? = null
    private var myLocation: Location? = null

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->
        if (granted) {
            Toast.makeText(requireContext(), "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun permissionGranted() = ContextCompat.checkSelfPermission(
        requireContext(), REQUIRED_PERMISSION
    ) == PackageManager.PERMISSION_GRANTED

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val addViewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)

        binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        addViewModel.text.observe(viewLifecycleOwner) {
        }

        if (!permissionGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
        

        binding.btnCamera.setOnClickListener { startCamera() }

        return root
    }


    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            showImage()
        }
    }

    private fun startCamera() {
        imageUri = getImageUri(requireContext())
        launcherIntentCamera.launch(imageUri)
    }


    private fun showImage() {
        imageUri?.let {
            Log.d("Image Uri", "showImage: $it")
            binding.imageFrame.setImageURI(it)
        }
    }
    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}