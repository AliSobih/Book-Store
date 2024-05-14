package book.com.bookstore.dao;

import book.com.bookstore.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CategoryRepo extends JpaRepository<ProductCategory, Long> {
}
