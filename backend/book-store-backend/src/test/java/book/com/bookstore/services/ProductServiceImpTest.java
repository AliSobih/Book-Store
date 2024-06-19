package book.com.bookstore.services;

import book.com.bookstore.dao.ProductRepo;
import book.com.bookstore.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImpTest {

    @Mock
    private ProductRepo productRepository;

    @InjectMocks
    private ProductServiceImp productServiceImp;

    private Product product;

    @BeforeEach
    void setUp() {
        product = Product.builder()
                .id(1L)
                .name("Test Product")
                .description("Test Description")
                .imageUrl("test_image.jpg")
                .build();
    }

    @Test
    void testGetAllProducts() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> page = new PageImpl<>(Collections.singletonList(product));
        when(productRepository.findAll(pageable)).thenReturn(page);

        Page<Product> result = productServiceImp.getAllProducts(0, 10);

        assertEquals(1, result.getTotalElements());
        verify(productRepository, times(1)).findAll(pageable);
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productServiceImp.getProductById(1L);

        assertEquals("Test Product", result.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetProductByIdNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productServiceImp.getProductById(1L));
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetProductByCategoryId() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> page = new PageImpl<>(Collections.singletonList(product));
        when(productRepository.findByCategoryId(1L, pageable)).thenReturn(page);

        Page<Product> result = productServiceImp.getProductByCategoryId(1L, 0, 10);

        assertEquals(1, result.getTotalElements());
        verify(productRepository, times(1)).findByCategoryId(1L, pageable);
    }

    @Test
    void testGetProductByNameContaining() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> page = new PageImpl<>(Collections.singletonList(product));
        when(productRepository.findByNameContaining("Test", pageable)).thenReturn(page);

        Page<Product> result = productServiceImp.getProductByNameContaining("Test", 0, 10);

        assertEquals(1, result.getTotalElements());
        verify(productRepository, times(1)).findByNameContaining("Test", pageable);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        Product result = productServiceImp.createProduct(product);

        assertEquals("Test Product", result.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testUpdateProduct() {
        Product updatedProduct = Product.builder()
                .id(1L)
                .name("Updated Product")
                .description("Updated Description")
                .imageUrl("updated_image.jpg")
                .build();

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        Product result = productServiceImp.updateProduct(1L, updatedProduct);

        assertEquals("Updated Product", result.getName());
        assertEquals("Updated Description", result.getDescription());
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        productServiceImp.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
