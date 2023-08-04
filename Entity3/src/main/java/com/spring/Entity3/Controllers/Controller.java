package com.spring.Entity3.Controllers;

//select lpad( max(substr(accno,3,3)) + 1,3,'0') From bank where substr(accno,2,1)='E';

import com.spring.Entity3.Models.Bank;
import com.spring.Entity3.Models.BankEntity;
import com.spring.Entity3.Models.Employee;
import com.spring.Entity3.Services.BankService;
import com.spring.Entity3.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    EmployeeService service;
    @Autowired
    BankService bService;

    @GetMapping("/num/{empNo}")
    public Employee searchByEmpNo(@PathVariable("empNo") int empNo){
        return service.getEmployeeByEmpNo(empNo);
    }

    @GetMapping("/name/{name}")
    public List<Employee> searchByName(@PathVariable("name") String name){
        return service.getEmployeeByName(name);
    }

    @GetMapping("/dep/{dep}")
    public List<Employee> searchByDepartment(@PathVariable("dep") String dep){
        return service.getEmployeeByDepartment(dep);
    }

    @GetMapping("/add/{a}/{b}/{c}/{d}")
    public String addEmployee(@PathVariable("a") int num, @PathVariable("b") String na, @PathVariable("c") String dep, @PathVariable("d") int sal){
        return service.addEmployee(num, na, dep, sal);
    }

    @PostMapping("/employee")
    public String saveRecord(@RequestBody Employee emp){
        return service.saveEmployee(emp);
    }

    @DeleteMapping("/del/{no}")
    public String delete(@PathVariable("no") int no){
        if(service.getEmployeeByEmpNo(no) == null){
            return "Employee not found";
        }else {
            return service.deleteId(no);
        }
    }

    @GetMapping("/all")
    public List<Employee> allRecords(){
        return service.getAll();
    }

    @GetMapping("/depCit/{dep}/{cit}")
    public List<Employee> depAndCit(@PathVariable("dep") String dep, @PathVariable("cit") String cit){
        return service.getEmployeeByDepartmentAndCity(dep,cit);
    }

    @GetMapping("/cit/{cit}")
    public  List<Employee> city(@PathVariable("cit") String cit){
        return service.getEmployeeByCity(cit);
    }

    @GetMapping("/queryAll")
    public List<Employee> qAll(){
        return service.getQueryAll();
    }

    @GetMapping("/queryName")
    public List<String> qName(){
        return service.getQueryName();
    }


    //bank things
    @PostMapping("/newAcc")
    public String openNew(@RequestBody Bank b){
        return bService.newAccountNo(b);
    }

    @GetMapping("findAcc/{type}/{country}")
    public List<BankEntity> findAcc(@PathVariable("type") String type, @PathVariable("country") String country){
        return bService.findAcc(type, country);
    }

    @GetMapping("findType/{t}")
    public List<BankEntity> findType(@PathVariable("t") String type){
        return bService.findAccType(type);
    }

}
