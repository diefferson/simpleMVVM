package br.com.disapps.simplemvvm.di

import br.com.disapps.simplemvvm.MainActivity
import br.com.disapps.simplemvvm.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by diefferson on 28/11/2017.
 */
@Module
abstract class ActivityBindsModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}