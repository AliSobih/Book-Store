package book.com.bookstore.services;

import book.com.bookstore.dao.StateRepo;
import book.com.bookstore.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImp implements StateService{
    private final StateRepo stateRepo;

    @Override
    public  List<State> findAllStates() {
        return stateRepo.findAll();
    }
    @Override
    public List<State> findByCountryCode(String code) {
        return stateRepo.findByCountryCode(code);
    }
}
