package com.java.redis.Repo;

import com.java.redis.Model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepo extends CrudRepository<Employee, UUID> {
}
