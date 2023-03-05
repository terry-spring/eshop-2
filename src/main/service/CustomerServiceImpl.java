package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.model.Customer;
import main.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public long findByUser(String user) {
        Customer customer = customerRepository.getByUserId(user);
        return customer.getCustomerId();
    }

}
