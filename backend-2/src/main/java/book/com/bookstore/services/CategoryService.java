package book.com.bookstore.services;

import book.com.bookstore.entity.ProductCategory;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    List<ProductCategory> findAllCategory();
}
