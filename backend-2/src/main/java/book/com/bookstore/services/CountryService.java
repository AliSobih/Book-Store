package book.com.bookstore.services;

import book.com.bookstore.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountries();
}
