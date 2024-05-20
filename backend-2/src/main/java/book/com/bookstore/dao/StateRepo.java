package book.com.bookstore.dao;

import book.com.bookstore.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StateRepo extends JpaRepository<State, Long> {
    List<State> findByCountryCode(@Param("code") String code);
}
