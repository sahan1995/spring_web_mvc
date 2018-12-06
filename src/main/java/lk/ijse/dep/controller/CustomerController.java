package lk.ijse.dep.controller;

import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handleMyExeception(RuntimeException ex){
        ex.printStackTrace();
        return ex.getMessage();
    }
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> findAllCustomer(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public CustomerDTO findById(@PathVariable("id") String id){
       return customerService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void saveCustomer(@PathVariable("id") String id,@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(id,customerDTO);

    }

    @PostMapping(value = "/{id}")
    public boolean updateCustomer(@PathVariable("id") String id,@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(id,customerDTO);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") String id){
        return customerService.removeCustomer(id);
    }

    @GetMapping(params = {"action=count"})
    public long customerCount(){
        return customerService.customerCount();
    }

    @GetMapping(params = {"action=search","q"})
    public List<CustomerDTO> addressFindByK(@RequestParam("q") String address){

        return customerService.customerStartWithK(address);
    }
}
