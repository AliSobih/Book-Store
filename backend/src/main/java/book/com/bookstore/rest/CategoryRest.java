package book.com.bookstore.rest;

import book.com.bookstore.entity.ProductCategory;
import book.com.bookstore.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-category")
public class CategoryRest {
    private final CategoryService categoryService;

    @GetMapping()
    public List<ProductCategory> findAllCategory() {
        return categoryService.findAllCategory();
    }
}
