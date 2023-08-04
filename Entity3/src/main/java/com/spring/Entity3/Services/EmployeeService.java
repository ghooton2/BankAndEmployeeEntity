package com.spring.Entity3.Services;

import com.spring.Entity3.Models.Bank;
import com.spring.Entity3.Models.Employee;
import com.spring.Entity3.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public Employee getEmployeeByEmpNo(int num){
        Employee emp = null;
        Optional<Employee> ref=repo.findById(num);
        if(ref.isPresent()){
            emp = ref.get();
        }
        return emp;
    }

    public List<Employee> getEmployeeByName(String name){
        return repo.findByName(name);
    }

    public List<Employee> getEmployeeByDepartment(String dep){
        return repo.findByDepartment(dep);
    }

    public List<Employee> getEmployeeByDepartmentAndCity(String dep, String cit){
        return repo.findByDepartmentAndCityOrderByName(dep, cit);
    }

    public List<Employee> getEmployeeByCity(String cit){
        return repo.findByCity(cit);
    }

    public String addEmployee(int num, String na, String dep, int sal){
        Employee emp = new Employee();
        emp.setEmpNo(num);
        emp.setDepartment(dep);
        emp.setSalary(sal);
        emp.setName(na);
        repo.save(emp);
        return "saved";
    }

    public String saveEmployee(Employee emp){
        repo.save(emp);
        return "Saved";
    }

    public String deleteId(int no){
        repo.deleteById(no);
        return "Record deleted";
    }

    public List<Employee> getAll(){
        List<Employee> emp = repo.findAll();
        return emp;
    }

    public List<Employee> getQueryAll(){
        return repo.queryAll();
    }

    public List<String> getQueryName(){
        return repo.queryName();
    }

}
