package mymemoryspace.backend.repository.jpa;

import mymemoryspace.backend.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



}