package book.com.bookstore.services;

import book.com.bookstore.dao.CountryRepo;
import book.com.bookstore.entity.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceImpTest {

    @Mock
    private CountryRepo countryRepo;

    @InjectMocks
    private CountryServiceImp countryServiceImp;

    private List<Country> countryList;

    @BeforeEach
    void setUp() {
        Country country1 = Country.builder()
                .id(1L)
                .code("US")
                .name("United States")
                .build();
        Country country2 = Country.builder()
                .id(2L)
                .code("CA")
                .name("Canada")
                .build();
        countryList = Arrays.asList(country1, country2);
    }

    @Test
    void testFindAllCountries() {
        when(countryRepo.findAll()).thenReturn(countryList);

        List<Country> result = countryServiceImp.findAllCountries();

        assertEquals(2, result.size());
        assertEquals("United States", result.get(0).getName());
        assertEquals("Canada", result.get(1).getName());
    }
}
