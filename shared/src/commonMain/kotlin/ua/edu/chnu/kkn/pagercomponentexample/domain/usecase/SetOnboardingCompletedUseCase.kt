package ua.edu.chnu.kkn.pagercomponentexample.domain.usecase

import ua.edu.chnu.kkn.pagercomponentexample.data.repository.SettingsRepository

class SetOnboardingCompletedUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(completed: Boolean = true) {
        settingsRepository.setOnboardingCompleted(completed)
    }
}
