package book.com.bookstore.services;

import book.com.bookstore.dao.CategoryRepo;
import book.com.bookstore.entity.ProductCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepo categoryRepo;
    @Override
    public List<ProductCategory> findAllCategory() {
        return categoryRepo.findAll();
    }
}
