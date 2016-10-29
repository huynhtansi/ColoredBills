package htsi.com.coloredbills.data.repository;

import android.util.Log;

import java.util.List;

import htsi.com.coloredbills.data.model.Bill;
import htsi.com.coloredbills.data.model.Category;
import htsi.com.coloredbills.data.model.Tag;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
public class HomeViewRepository implements IHomeViewRepository {

    public HomeViewRepository() {}

    @Override
    public List<Bill> getAllBills() {
        Log.i("HomeViewRepository","getAllBills");
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Tag> getAllTags() {
        return null;
    }
}
