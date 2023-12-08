package com.kai.capstone_rapidresq.ui.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kai.capstone_rapidresq.R
import com.kai.capstone_rapidresq.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var myButton: Button
    private lateinit var myEditText: EditText


    // This property is only valid between onCreateView and
    // onDestroyView.

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
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}