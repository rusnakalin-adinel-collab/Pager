package ua.edu.chnu.kkn.pagercomponentexample.di

import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ua.edu.chnu.kkn.pagercomponentexample.data.repository.SettingsRepository
import ua.edu.chnu.kkn.pagercomponentexample.data.repository.SettingsRepositoryImpl
import ua.edu.chnu.kkn.pagercomponentexample.domain.usecase.IsOnboardingCompletedUseCase
import ua.edu.chnu.kkn.pagercomponentexample.domain.usecase.SetOnboardingCompletedUseCase
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthViewModel
import ua.edu.chnu.kkn.pagercomponentexample.ui.main.MainViewModel
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingViewModel

val appModule: Module = module {
    single<Settings> { Settings() }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }

    factory { IsOnboardingCompletedUseCase(get()) }
    factory { SetOnboardingCompletedUseCase(get()) }

    viewModel { OnboardingViewModel(get(), get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { MainViewModel(get()) }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(appModule)
    }
}
