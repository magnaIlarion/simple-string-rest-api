package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.Person;
import ge.ibsu.demo.dto.Test;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/test")
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/call", method = RequestMethod.GET, produces = {"application/json"})

    public String test()
    {
        return "GUADALAJARA";
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.POST, produces = "application/json")
    public Test testPost(@RequestBody Person rd)
    {
        Test t = new Test();
        t.setFullName(rd.getFirstName() + " " + rd.getLastName());
        return t;
    }
}