package com.summerpractice.project.ui.developerMode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.summerpractice.project.databinding.FragmentDeveloperModeBinding


class DeveloperModeFragment : Fragment() {

    private var _binding: FragmentDeveloperModeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val developerModeViewModel =
            ViewModelProvider(this).get(DeveloperModeViewModel::class.java)

        _binding = FragmentDeveloperModeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDvlpMode
        developerModeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}