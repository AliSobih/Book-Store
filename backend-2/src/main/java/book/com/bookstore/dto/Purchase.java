package book.com.bookstore.dto;

import book.com.bookstore.entity.Address;
import book.com.bookstore.entity.Customer;
import book.com.bookstore.entity.Order;
import book.com.bookstore.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
