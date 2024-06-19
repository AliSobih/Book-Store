package book.com.bookstore.services;

import book.com.bookstore.dao.CategoryRepo;
import book.com.bookstore.entity.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImpTest {

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategoryServiceImp categoryServiceImp;

    private List<ProductCategory> categoryList;

    @BeforeEach
    void setUp() {
        ProductCategory category1 = ProductCategory.builder()
                .id(1L)
                .categoryName("Books")
                .build();
        ProductCategory category2 = ProductCategory.builder()
                .id(2L)
                .categoryName("Coffee mugs")
                .build();
        categoryList = Arrays.asList(category1, category2);
    }

    @Test
    void testFindAllCategory() {
        when(categoryRepo.findAll()).thenReturn(categoryList);

        List<ProductCategory> result = categoryServiceImp.findAllCategory();

        assertEquals(2, result.size());
        assertEquals("Books", result.get(0).getCategoryName());
        assertEquals("Coffee mugs", result.get(1).getCategoryName());
    }
}
