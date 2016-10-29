package htsi.com.coloredbills.presenter.home;

import javax.inject.Inject;

import htsi.com.coloredbills.data.repository.IHomeViewRepository;
import htsi.com.coloredbills.presenter.base.IBasePresenter;
import htsi.com.coloredbills.ui.view.IHomeView;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
public class HomePresenter implements IBasePresenter<IHomeView> {

    private IHomeView mHomeView;

    private IHomeViewRepository mHomeViewRepository;

    @Inject
    public HomePresenter(IHomeViewRepository homeViewRepository) {
        this.mHomeViewRepository = homeViewRepository;
    }

    @Override
    public void setView(IHomeView view) {
        mHomeView = view;
    }

    public void loadHomeView() {
        //mHomeViewRepository.getAllBills();
        mHomeView.showHomeView();
    }

    @Override
    public void destroyView() {

    }
}
