package com.sbtl.smartweaver.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sbtl.smartweaver.data.entity.Salary;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends PagingAndSortingRepository<Salary, Long> {
	List<Salary> findByDate(Date date);
}