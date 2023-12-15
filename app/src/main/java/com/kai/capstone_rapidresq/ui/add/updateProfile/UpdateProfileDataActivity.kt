package com.kai.capstone_rapidresq.ui.add.updateProfile

import android.Manifest
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.kai.capstone_rapidresq.MainActivity
import com.kai.capstone_rapidresq.databinding.ActivityUpdateProfileDataBinding
import com.kai.capstone_rapidresq.ui.add.getImageUri
import com.kai.capstone_rapidresq.ui.login.LoginActivity
import java.util.Calendar

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (!permissionGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        binding.birtDateEditText.setOnClickListener {
            binding.birtDateEditText.isFocusable = false
            showDatePicker()
        }

        binding.uploadProfile.setOnClickListener{startCamera()}
        binding.btnUpdate.setOnClickListener { toMain() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Aksi kembali
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun toMain(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                binding.birtDateEditText.setText(selectedDate)
            },
            year,
            month,
            dayOfMonth
        )

        datePickerDialog.setOnDismissListener {
            binding.birtDateEditText.isFocusableInTouchMode = true
        }

        datePickerDialog.show()
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