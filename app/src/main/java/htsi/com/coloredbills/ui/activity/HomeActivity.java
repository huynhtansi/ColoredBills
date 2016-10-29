package htsi.com.coloredbills.ui.activity;

import htsi.com.coloredbills.di.base.HasComponent;
import htsi.com.coloredbills.di.component.AppComponent;
import htsi.com.coloredbills.ui.fragment.BaseFragment;
import htsi.com.coloredbills.ui.fragment.HomeFragment;

public class HomeActivity extends BaseActivity implements HasComponent<AppComponent> {

    private AppComponent mAppComponent;

    @Override
    protected BaseFragment hostFragment() {
        return new HomeFragment();
    }

    @Override
    public AppComponent getComponent() {
        return mAppComponent;
    }

    @Override
    protected void setupActivityComponent() {
        mAppComponent = getApplicationComponent();
    }
}
