package book.com.bookstore.services;

import book.com.bookstore.dao.CustomerRepository;
import book.com.bookstore.dto.Purchase;
import book.com.bookstore.dto.PurchaseResponse;
import book.com.bookstore.entity.Address;
import book.com.bookstore.entity.Customer;
import book.com.bookstore.entity.Order;
import book.com.bookstore.entity.OrderItem;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImp implements CheckoutService{
    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();

        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();

        orderItems.forEach(order::add);


        order.setShippingAddress(purchase.getShippingAddress());
        order.setShippingAddress(purchase.getBillingAddress());

        Customer customer = purchase.getCustomer();

        customer.add(order);
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
