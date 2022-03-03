package com.example.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simpleform.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fName = arguments?.getString("first_name")
        val lName = arguments?.getString("last_name")
        val cName = arguments?.getString("college_name")
        val isCollege = arguments?.getBoolean("is_college_completed")
        val isHappy = arguments?.getBoolean("are_you_happy")
        val gender = arguments?.getString("gender")

        binding.edtFname.text = fName
        binding.edtLName.text = lName
        binding.edtCollName.text = cName
        binding.edtGend.text = gender
        binding.edtCollComplete.text = if(isCollege == true){"Yes"} else{"false"}
        binding.edtHappy.text = if(isHappy == true){"Yes"} else{"false"}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}