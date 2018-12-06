package lk.ijse.dep.repository;

import lk.ijse.dep.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {


    @Query("SELECT c FROM Customer c WHERE c.address LIKE ?1%")
    List<Customer> customerStartWithK(String address);
}
