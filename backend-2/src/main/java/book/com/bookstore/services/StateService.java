package book.com.bookstore.services;

import book.com.bookstore.entity.State;

import java.util.List;

public interface StateService {
    List<State> findAllStates();
    List<State> findByCountryCode(String code);
}
