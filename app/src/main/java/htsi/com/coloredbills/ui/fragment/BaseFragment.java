package htsi.com.coloredbills.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import htsi.com.coloredbills.di.base.HasComponent;

/**
 * Created by Huỳnh Phúc on 9/15/2016.
 */
public class BaseFragment extends Fragment {

    protected void onScreenVisible(){}

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onScreenVisible();
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
