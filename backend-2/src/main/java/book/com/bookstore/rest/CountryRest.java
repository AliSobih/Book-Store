package book.com.bookstore.rest;

import book.com.bookstore.entity.Country;
import book.com.bookstore.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryRest {
    private final CountryService countryService;

    @GetMapping()
    public List<Country> getAllCountries() {
        return countryService.findAllCountries();
    }
}
