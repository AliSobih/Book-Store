package book.com.bookstore.services;

import book.com.bookstore.dao.CustomerRepository;
import book.com.bookstore.dto.Purchase;
import book.com.bookstore.dto.PurchaseResponse;
import book.com.bookstore.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CheckoutServiceImpTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CheckoutServiceImp checkoutServiceImp;

    private Purchase purchase;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer();
        Address shippingAddress = new Address();
        Address billingAddress = new Address();
        Order order = new Order();
        order.setTotalQuantity(2);
        order.setTotalPrice(BigDecimal.valueOf(100));
        Set<OrderItem> orderItems = new HashSet<>();
        OrderItem item1 = new OrderItem();
        item1.setProductId(1L);
        item1.setQuantity(1);
        item1.setUnitPrice(BigDecimal.valueOf(50));
        OrderItem item2 = new OrderItem();
        item2.setProductId(2L);
        item2.setQuantity(1);
        item2.setUnitPrice(BigDecimal.valueOf(50));
        orderItems.add(item1);
        orderItems.add(item2);

        purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setShippingAddress(shippingAddress);
        purchase.setBillingAddress(billingAddress);
        purchase.setOrder(order);
        purchase.setOrderItems(orderItems);
    }

    @Test
    void testPlaceOrder() {
        PurchaseResponse response = checkoutServiceImp.placeOrder(purchase);

        verify(customerRepository).save(purchase.getCustomer());
        assertEquals(36, response.getOrderTrackingNumber().length());
    }
}
