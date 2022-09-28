package com.java.redis.Controller;

import com.java.redis.Model.Employee;
import com.java.redis.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.employees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> get(@PathVariable UUID id){
        return ResponseEntity.ok(employeeService.getEmp(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        employeeService.deleteEmp(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted!");
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        employeeService.update(employee);
        return ResponseEntity.accepted().body(employee);
    }


}
