package book.com.bookstore.services;


import book.com.bookstore.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Page<Product> getAllProducts(int page, int size);
    public Product getProductById(Long id);
    public Page<Product> getProductByCategoryId(Long id, int page, int size);
    public Page<Product> getProductByNameContaining(String name, int page, int size);
    public Product createProduct(Product product);
    public Product updateProduct(Long id, Product updatedProduct);
    public void deleteProduct(Long id);

}
