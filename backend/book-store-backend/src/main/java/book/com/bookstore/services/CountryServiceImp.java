package book.com.bookstore.services;

import book.com.bookstore.dao.CountryRepo;
import book.com.bookstore.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImp implements CountryService{
    private final CountryRepo countryRepo;
    @Override
    public List<Country> findAllCountries() {
        return countryRepo.findAll();
    }
}
