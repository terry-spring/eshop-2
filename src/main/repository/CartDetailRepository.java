package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    @Query("from Cart c where c.customerId = :customerId")
    public List<CartDetail> getByCustomerId(@Param("customerId") long login);

}
