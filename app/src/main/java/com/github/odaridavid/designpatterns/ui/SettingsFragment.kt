package com.github.odaridavid.designpatterns.ui

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.helpers.SdkUtils
import com.github.odaridavid.designpatterns.helpers.ThemeUtils
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_DARK
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_LIGHT
import com.github.odaridavid.designpatterns.helpers.ThemeUtils.THEME_SYSTEM

class SettingsFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var themePreference: ListPreference? = null
    private val themePreferenceKey: String by lazy {
        getString(R.string.key_theme_preference)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        themePreference = findPreference(themePreferenceKey)

        configPreference(themePreference)

        preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    private fun configPreference(themePreference: ListPreference?) {
        val themeArrayOptionsAboveQ = resources.getStringArray(R.array.theme_options_above_q)
        val themeArrayOptionsBelowQ = resources.getStringArray(R.array.theme_options_below_q)

        themePreference?.entries =
            if (SdkUtils.versionFrom(Build.VERSION_CODES.Q))
                themeArrayOptionsAboveQ
            else
                themeArrayOptionsBelowQ

        themePreference?.summaryProvider =
            Preference.SummaryProvider<ListPreference> { preference ->
                getString(getPreferenceSummary(preference))
            }
    }

    @StringRes
    private fun getPreferenceSummary(preference: ListPreference): Int {
        return when (preference.value) {
            THEME_LIGHT -> R.string.pref_summary_theme_light
            THEME_DARK -> R.string.pref_summary_theme_dark
            THEME_SYSTEM -> {
                if (SdkUtils.versionFrom(Build.VERSION_CODES.Q))
                    R.string.pref_summary_theme_system_above_q
                else
                    R.string.pref_summary_theme_system_below_q
            }
            else -> R.string.pref_summary_theme_light
        }
    }

    private fun setupThemePreferenceIcons(themePreference: ListPreference?) {
        val themeValue = preferenceManager.sharedPreferences.getString(themePreferenceKey, DEFAULT_THEME_VALUE)
        themePreference?.icon = getDrawable(requireContext(), getThemeIcon(themeValue))
    }

    @DrawableRes
    private fun getThemeIcon(themeValue: String?): Int {
        return when (themeValue) {
            THEME_LIGHT -> R.drawable.ic_day_black_24dp
            THEME_DARK -> R.drawable.ic_night_black_24dp
            THEME_SYSTEM -> R.drawable.ic_day_black_24dp
            else -> R.drawable.ic_day_black_24dp
        }
    }

    override fun onResume() {
        super.onResume()
        setupThemePreferenceIcons(themePreference)
    }

    override fun onDestroy() {
        super.onDestroy()
        preferenceManager.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(prefs: SharedPreferences?, key: String?) {
        if (key == themePreferenceKey) {
            ThemeUtils.updateTheme(prefs!!, key)
        }
    }

    companion object {
        const val DEFAULT_THEME_VALUE = "Light"
    }

}
