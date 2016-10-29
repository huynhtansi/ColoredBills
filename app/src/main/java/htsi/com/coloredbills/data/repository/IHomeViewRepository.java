package htsi.com.coloredbills.data.repository;

import java.util.List;

import htsi.com.coloredbills.data.model.Bill;
import htsi.com.coloredbills.data.model.Category;
import htsi.com.coloredbills.data.model.Tag;

/**
 * Created by Huỳnh Phúc on 9/18/2016.
 */
public interface IHomeViewRepository {

    List<Bill> getAllBills();
    List<Category> getAllCategories();
    List<Tag> getAllTags();
}
