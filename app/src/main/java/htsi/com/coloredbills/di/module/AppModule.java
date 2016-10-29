package htsi.com.coloredbills.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import htsi.com.coloredbills.data.repository.HomeViewRepository;
import htsi.com.coloredbills.data.repository.IHomeViewRepository;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application pApplication) {
        mApplication = pApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    IHomeViewRepository provideHomeViewRepository() {
        return new HomeViewRepository();
    }

}
