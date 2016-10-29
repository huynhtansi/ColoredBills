package htsi.com.coloredbills.app;

import android.app.Application;

import htsi.com.coloredbills.R;
import htsi.com.coloredbills.di.component.AppComponent;
import htsi.com.coloredbills.di.component.DaggerAppComponent;
import htsi.com.coloredbills.di.module.AppModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Huỳnh Phúc on 9/15/2016.
 */
public class ColoredBillsApplication extends Application {

    private static ColoredBillsApplication mInstance;

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public ColoredBillsApplication() {
        mInstance = this;
    }

    public static ColoredBillsApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        //  Set default font to MyriadPro
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(Constants.APP_DEFAULT_FONT)
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
