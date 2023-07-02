package com.summerpractice.project.ui.settings

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.summerpractice.project.R
import com.summerpractice.project.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    val className = this::class.java.simpleName
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding?.run{
            dvlpmode.setOnClickListener {

                val snackbar = Snackbar.make(it, "SettingsFragment",Snackbar.LENGTH_LONG).setAction("Action",null)
                val snackbarView = snackbar.view
                snackbarView.setBackgroundColor(Color.BLACK)
                snackbar.show()
                findNavController().navigate(
                    R.id.action_navigation_settings_to_developerModeFragment,
                    createBundle(className)
                )
            }
        }
        return root
    }

    companion object{
        fun createBundle(str : String): Bundle {
            var bundle = Bundle()
            bundle.putString("SettingsFragment", str)
            return bundle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}