package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from User u where u.login = :login")
    public Customer getByUserId(@Param("login") String login);

    // public Customer getByUserId(long userId);
}
