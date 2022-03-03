package com.example.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.simpleform.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            sendData()
        }
        binding.btnClear.setOnClickListener { clearForm() }

    }

    private fun clearForm() {
        binding.editFName.setText("")
        binding.editLName.setText("")
        binding.editColName.setText("")
        binding.ckboxCollegeComplete.clearFocus()
        binding.ckboxHappy.clearFocus()
        binding.rdButtonMale.clearFocus()
        binding.rdButtonFemale.clearFocus()
    }

    private fun sendData() {
        val fName = binding.editFName.text.toString()
        val lName = binding.editLName.text.toString()
        val collName = binding.editColName.text.toString()
        val happy = binding.ckboxHappy.isChecked
        val collComplete = binding.ckboxCollegeComplete.isChecked

        var gender = when (binding.genderOption.checkedRadioButtonId) {
            R.id.rdButtonMale -> "Male"
            R.id.rdButtonFemale -> "Female"
            else -> "null"
        }

        val bundle = bundleOf(
                "first_name" to fName,
                "last_name" to lName,
                "college_name" to collName,
                "gender" to gender,
                "is_college_completed" to collComplete,
                "are_you_happy" to happy
        )
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}