package com.sbtl.smartweaver.data.repository;

import com.sbtl.smartweaver.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByEmpid(long empId);
   
}