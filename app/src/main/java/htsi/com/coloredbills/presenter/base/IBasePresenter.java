package htsi.com.coloredbills.presenter.base;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
public interface IBasePresenter<ViewType> {

    void setView(ViewType view);

    void destroyView();
}
