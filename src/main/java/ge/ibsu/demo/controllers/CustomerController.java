package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.AddCustomerDTO;
import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.services.CustomerService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Customer> getAll()
    {
        return customerService.retrieveAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Customer getOne(@PathVariable Long id)
    {
        return customerService.getCustomer(id);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public Customer add(@RequestBody AddCustomerDTO addCustomerDTO) throws Exception {
        GeneralUtil.checkRequiredProperties(addCustomerDTO, Arrays.asList("firstName", "lastName", "address"));
        return customerService.addCostumer(addCustomerDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Customer edit(@PathVariable Long id, @RequestBody AddCustomerDTO addCustomerDTO) throws Exception {
        GeneralUtil.checkRequiredProperties(addCustomerDTO, Arrays.asList("firstName", "lastName", "address"));
        return customerService.editCustomer(id, addCustomerDTO);
    }
}