package htsi.com.coloredbills.di.component;

import javax.inject.Singleton;

import dagger.Component;
import htsi.com.coloredbills.data.repository.IHomeViewRepository;
import htsi.com.coloredbills.di.module.AppModule;
import htsi.com.coloredbills.ui.activity.BaseActivity;
import htsi.com.coloredbills.ui.fragment.BaseFragment;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent {

    IHomeViewRepository homeViewRepository();

    void inject(BaseActivity baseActivity);
    void inject(BaseFragment baseFragment);
}
