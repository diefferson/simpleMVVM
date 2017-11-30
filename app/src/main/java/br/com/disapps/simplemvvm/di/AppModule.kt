package br.com.disapps.simplemvvm.di

import android.app.Application
import android.arch.persistence.room.Room
import br.com.disapps.simplemvvm.BuildConfig
import br.com.disapps.simplemvvm.api.IRestApi
import br.com.disapps.simplemvvm.app.App
import br.com.disapps.simplemvvm.db.AppDB
import br.com.disapps.simplemvvm.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by diefferson on 28/11/2017.
 */
@Module
class AppModule {

    @Provides
    fun provideApp(): App = App.instance!!

    @Singleton
    @Provides
    fun provideIRestApi(): IRestApi {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(IRestApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDB =
            Room.databaseBuilder(app, AppDB::class.java, "vivamais.db").build()

}
