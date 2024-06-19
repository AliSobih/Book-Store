package book.com.bookstore.services;

import book.com.bookstore.dao.StateRepo;
import book.com.bookstore.entity.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StateServiceImpTest {

    @Mock
    private StateRepo stateRepo;

    @InjectMocks
    private StateServiceImp stateServiceImp;

    private State state;

    @BeforeEach
    void setUp() {
        state = new State();
        state.setId(1L);
        state.setName("Test State");
    }

    @Test
    void testFindAllStates() {
        when(stateRepo.findAll()).thenReturn(Arrays.asList(state));

        List<State> result = stateServiceImp.findAllStates();

        assertEquals(1, result.size());
        assertEquals("Test State", result.get(0).getName());
        verify(stateRepo, times(1)).findAll();
    }

    @Test
    void testFindByCountryCode() {
        when(stateRepo.findByCountryCode("US")).thenReturn(Arrays.asList(state));

        List<State> result = stateServiceImp.findByCountryCode("US");

        assertEquals(1, result.size());
        assertEquals("Test State", result.get(0).getName());
        verify(stateRepo, times(1)).findByCountryCode("US");
    }
}
