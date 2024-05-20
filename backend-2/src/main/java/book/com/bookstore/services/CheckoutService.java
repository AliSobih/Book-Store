package book.com.bookstore.services;

import book.com.bookstore.dto.Purchase;
import book.com.bookstore.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
