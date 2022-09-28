package com.java.redis.Service;

import com.java.redis.Model.Employee;
import com.java.redis.Repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public void save(Employee employee){
        employee.setId(UUID.randomUUID());
        employeeRepo.save(employee);
    }

    public Iterable<Employee> employees(){
        return employeeRepo.findAll();
    }

    public Employee getEmp(UUID uuid){
        return employeeRepo.findById(uuid).get();
    }

    public void deleteEmp(UUID uuid){
        employeeRepo.deleteById(uuid);
    }

    public void update(Employee employee){
        employeeRepo.save(employee);
    }
}
