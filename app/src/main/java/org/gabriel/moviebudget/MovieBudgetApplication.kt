package org.gabriel.moviebudget

import android.app.Application
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator
import toothpick.smoothie.module.SmoothieApplicationModule


class MovieBudgetApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
        MemberInjectorRegistryLocator.setRootRegistry(org.gabriel.moviebudget.MemberInjectorRegistry())
        FactoryRegistryLocator.setRootRegistry(org.gabriel.moviebudget.FactoryRegistry())

        val appScope = Toothpick.openScope(this)
        appScope.installModules(
                SmoothieApplicationModule(this),
                MovieBudgetApplicationModule()
        )
    }
}