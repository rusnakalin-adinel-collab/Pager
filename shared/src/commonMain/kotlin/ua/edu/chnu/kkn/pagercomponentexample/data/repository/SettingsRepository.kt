package ua.edu.chnu.kkn.pagercomponentexample.data.repository

import com.russhwolf.settings.Settings

interface SettingsRepository {
    fun isOnboardingCompleted(): Boolean
    fun setOnboardingCompleted(completed: Boolean)
    fun isUkrainianLanguage(): Boolean
    fun setUkrainianLanguage(isUkrainian: Boolean)
    fun clearAll()
}

class SettingsRepositoryImpl(
    private val settings: Settings = Settings()
) : SettingsRepository {

    companion object {
        private const val KEY_ONBOARDING_COMPLETED = "key_onboarding_completed"
        private const val KEY_LANGUAGE_UA = "key_language_ua"
    }

    override fun isOnboardingCompleted(): Boolean {
        return settings.getBoolean(KEY_ONBOARDING_COMPLETED, defaultValue = false)
    }

    override fun setOnboardingCompleted(completed: Boolean) {
        settings.putBoolean(KEY_ONBOARDING_COMPLETED, completed)
    }

    override fun isUkrainianLanguage(): Boolean {
        return settings.getBoolean(KEY_LANGUAGE_UA, defaultValue = true)
    }

    override fun setUkrainianLanguage(isUkrainian: Boolean) {
        settings.putBoolean(KEY_LANGUAGE_UA, isUkrainian)
    }

    override fun clearAll() {
        settings.clear()
    }
}
