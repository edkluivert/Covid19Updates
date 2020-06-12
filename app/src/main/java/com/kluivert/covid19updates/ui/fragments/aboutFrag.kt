package com.kluivert.covid19updates.ui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.kluivert.covid19updates.R
import com.kluivert.covid19updates.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_about.*

class aboutFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        nightModeSwitch.isChecked =
            when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> true
                else -> false
            }

        nightModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            activity?.apply {
                this as MainActivity

                delegate.localNightMode = when(isChecked) {
                    true -> AppCompatDelegate.MODE_NIGHT_YES
                    false -> AppCompatDelegate.MODE_NIGHT_NO
                }

                with(getPreferences(Context.MODE_PRIVATE).edit()) {
                    putBoolean(getString(R.string.night_mode_prefs_key), isChecked)
                    apply()
                }
            }
        }
    }
}