package com.kai.capstone_rapidresq.ui.add.updateProfile

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.kai.capstone_rapidresq.databinding.ActivityUpdateProfileDataBinding
import com.kai.capstone_rapidresq.ui.add.getImageUri

class UpdateProfileDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateProfileDataBinding
    private var imageUri: Uri? = null
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted: Boolean ->
        if (granted) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    private fun permissionGranted() = ContextCompat.checkSelfPermission(
        this, REQUIRED_PERMISSION
    ) == PackageManager.PERMISSION_GRANTED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!permissionGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        binding.uploadProfile.setOnClickListener{startCamera()}
    }

    private fun showImage() {
        imageUri?.let {
            Log.d("Image Uri", "showImage: $it")
            binding.ivProfile.setImageURI(it)
        }
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            showImage()
        }
    }

    private fun startCamera() {
        imageUri = getImageUri(this)
        launcherIntentCamera.launch(imageUri)
    }
    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}