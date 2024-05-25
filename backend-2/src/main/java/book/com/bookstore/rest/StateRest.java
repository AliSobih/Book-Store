package book.com.bookstore.rest;

import book.com.bookstore.entity.State;
import book.com.bookstore.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
public class StateRest {
    private final StateService stateService;

    @GetMapping()
    public List<State> findAllStates() {
        return stateService.findAllStates();
    }

    @GetMapping("/search/findByCountryCode")
    public List<State> findBuCountryCode(@RequestParam("code") String code) {
        return stateService.findByCountryCode(code);
    }
}
