package htsi.com.coloredbills.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import htsi.com.coloredbills.R;
import htsi.com.coloredbills.di.component.AppComponent;
import htsi.com.coloredbills.presenter.home.HomePresenter;
import htsi.com.coloredbills.ui.activity.BaseActivity;
import htsi.com.coloredbills.ui.view.IHomeView;

/**
 * Created by Huỳnh Phúc on 9/15/2016.
 */
public class HomeFragment extends BaseFragment implements IHomeView {

    @Inject
    HomePresenter mHomePresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.contentNewBill)
    ViewGroup mContentNewBill;

    @BindView(R.id.spViewMode)
    Spinner mSpViewMode;

    @BindView(R.id.spCategory)
    Spinner mSpCategory;

    @BindView(R.id.spTag)
    Spinner mSpTags;

    // 0: Normar - 1: Add Bill
    private int mState  = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void initialize() {
        this.getComponent(AppComponent.class).inject(this);
        //mHomePresenter.setView(this);
    }

    @Override
    protected void onScreenVisible() {
        super.onScreenVisible();

        initialize();

        ((BaseActivity)getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);

        //mHomePresenter.loadHomeView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        //inflater.inflate(R.menu.home, menu);
    }



    @OnClick(R.id.btnAddBill)
    public void onButtonAddBillClicked(View view) {

        toggleInformationView(view);
    }

    private void toggleInformationView(View view) {

        float angle = 0;
        int cx = (view.getBottom() - view.getTop())/2;
        int cy = (view.getRight() - view.getLeft())/2 -24;
        float radius = Math.max(mContentNewBill.getWidth(), mContentNewBill.getHeight()) * 2.0f;

        Animator reveal;
        if (mContentNewBill.getVisibility() == View.INVISIBLE) {
            mContentNewBill.setVisibility(View.VISIBLE);
            reveal = ViewAnimationUtils.createCircularReveal(
                    mContentNewBill, cx, cy, 0, radius);
            reveal.setInterpolator(new AccelerateInterpolator(2.0f));
            angle = 45.0f;
            // Hide View-Mode, Show Category - Tag
            mSpViewMode.setVisibility(View.GONE);
            mSpTags.setVisibility(View.VISIBLE);
            // Change state
            mState = 1;
        } else {
            reveal = ViewAnimationUtils.createCircularReveal(
                    mContentNewBill, cx, cy, radius, 0);
            reveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mContentNewBill.setVisibility(View.INVISIBLE);
                }
            });
            reveal.setInterpolator(new DecelerateInterpolator(2.0f));
            angle = 0.0f;
            // Show View-Mode, Hide Category - Tag
            mSpTags.setVisibility(View.GONE);
            mSpViewMode.setAlpha(0.0f);
            mSpViewMode.animate().alpha(1.0f)
                    .setDuration(200)
                    .setInterpolator(new DecelerateInterpolator(2.0f)).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mSpViewMode.setVisibility(View.VISIBLE);
                }
            });
            // Change state
            mState = 0;
        }
        reveal.setDuration(600);
        reveal.start();
        view.animate().
                setInterpolator(new DecelerateInterpolator(2.0f)).
                rotation(angle).
                setDuration(600);

        mToolbar.setTitle(mState == 0? R.string.app_name:R.string.new_bill);
    }

    @Override
    public void showHomeView() {

    }
}
