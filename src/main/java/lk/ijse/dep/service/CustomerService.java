package lk.ijse.dep.service;

import lk.ijse.dep.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {


     List<CustomerDTO> getAllCustomers();

     void addCustomer(String id ,CustomerDTO customerDTO);

     boolean updateCustomer(String id,CustomerDTO customerDTO);

     boolean removeCustomer(String id);

     CustomerDTO findById(String id);

     long customerCount();

     List<CustomerDTO> customerStartWithK(String address);

}
