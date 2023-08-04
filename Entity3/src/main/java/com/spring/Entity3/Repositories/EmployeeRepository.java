package com.spring.Entity3.Repositories;

import com.spring.Entity3.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String x);
    List<Employee> findByDepartment(String y);
    List<Employee> findByDepartmentAndCityOrderByName(String dep, String cit);
    List<Employee> findByCity(String c);

    @Query(value = "Select * from employee_info", nativeQuery = true)
    List<Employee> queryAll();

    @Query(value = "Select distinct name from employee_info", nativeQuery = true)
    List<String> queryName();

    //bank things



}
