package br.com.disapps.simplemvvm.di

import android.app.Application
import br.com.disapps.simplemvvm.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by diefferson on 28/11/2017.
 */
@Singleton
@Component(modules = arrayOf(
                AndroidInjectionModule::class,
                AppModule::class,
                ActivityBindsModule::class,
                ViewModelModule::class,
                FragmentBuildersModule::class
        ))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

}