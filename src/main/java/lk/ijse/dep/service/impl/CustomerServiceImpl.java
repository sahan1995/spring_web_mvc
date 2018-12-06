package lk.ijse.dep.service.impl;

import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.repository.CustomerRepository;
import lk.ijse.dep.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> all =
                customerRepository.findAll();
        var customerDTO = new ArrayList<CustomerDTO>();

        for (Customer customer : all) {
            customerDTO.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));

        }
        return customerDTO;
    }

    @Override
    public void addCustomer(String id, @RequestBody CustomerDTO customerDTO) {

        if (!id.equals(customerDTO.getId())) {
            throw new RuntimeException("Not Same");
        }
        customerRepository.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));


    }

    @Override
    public boolean updateCustomer(String id, @RequestBody CustomerDTO customerDTO) {
        if (!id.equals(customerDTO.getId())) {
            throw new RuntimeException("Not Same");
        }
        customerRepository.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
        return true;


    }

    @Override
    public boolean removeCustomer(String id) {
    customerRepository.deleteById(id);
    return true;


    }

    @Override
    public CustomerDTO findById(String id) {
        Optional<Customer> byId =
                customerRepository.findById(id);
        Customer customer = byId.get();
         return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

    }

    @Override
    public long customerCount() {
        return customerRepository.count();
    }

    @Override
    public List<CustomerDTO> customerStartWithK(String address) {
        List<Customer> customers = customerRepository.customerStartWithK(address);
        var dtos = new ArrayList<CustomerDTO>();
        for (Customer customer : customers) {
            dtos.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));

        }

        return dtos;

    }

}
