package main.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.model.Customer;

/**
 * 客戶repository
 * @author sam
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

//	@Query("from Customer c left join fetch c.comments where c.customerId = :customerId")
//	public Customer getByIdWithComments(@Param("customerId") long customerId);
	
	@Query("from Customer c where c.userId = :userId")
	public List<Customer> getByUserId(@Param("userId") long userId);
		
//	public List<Customer> findAll();
	
	 @Query("SELECT c FROM Customer c WHERE CONCAT(c.companyName, c.contactName, c.phonenumber) LIKE %?1%")
	 public List<Customer> search(@Param("keyword") String keyword);
	
}