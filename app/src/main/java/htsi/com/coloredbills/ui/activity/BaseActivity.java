package htsi.com.coloredbills.ui.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import htsi.com.coloredbills.R;
import htsi.com.coloredbills.app.ColoredBillsApplication;
import htsi.com.coloredbills.di.component.AppComponent;
import htsi.com.coloredbills.ui.fragment.BaseFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Huỳnh Phúc on 9/15/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected AppComponent getApplicationComponent() {
        return ((ColoredBillsApplication) getApplication()).getAppComponent();
    }

    protected void setupActivityComponent() {
        // Implement in child class
    }

    private void addFragment(BaseFragment baseFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tf = fm.beginTransaction();
        tf.add(R.id.container, baseFragment, baseFragment.getClass().getName());
        tf.commit();
    }

    protected BaseFragment hostFragment() {
        // Implement in child class
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setupActivityComponent();
        setContentView(R.layout.activity_base);
        if (savedInstanceState == null) {
            addFragment(hostFragment());
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
