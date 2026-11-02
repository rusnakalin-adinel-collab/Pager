package ua.edu.chnu.kkn.pagercomponentexample.domain.usecase

import ua.edu.chnu.kkn.pagercomponentexample.data.repository.SettingsRepository

class IsOnboardingCompletedUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(): Boolean {
        return settingsRepository.isOnboardingCompleted()
    }
}
