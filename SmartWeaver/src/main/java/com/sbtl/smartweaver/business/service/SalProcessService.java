package com.sbtl.smartweaver.business.service;

import com.sbtl.smartweaver.business.domain.SalaryProcessor;
import com.sbtl.smartweaver.data.entity.Employee;
import com.sbtl.smartweaver.data.entity.Loom;
import com.sbtl.smartweaver.data.entity.Salary;
import com.sbtl.smartweaver.data.entity.Stocking;
import com.sbtl.smartweaver.data.repository.SalaryRepository;
import com.sbtl.smartweaver.data.repository.EmployeeRepository;
import com.sbtl.smartweaver.data.repository.LoomRepository;
import com.sbtl.smartweaver.data.repository.StockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalProcessService {
	private EmployeeRepository empRepository;
	private SalaryRepository salaryRepository;

	@Autowired
	StockingService stockService = new StockingService();

	@Autowired
	public SalProcessService(EmployeeRepository empRepository, 
			SalaryRepository salaryRepository) {

		this.empRepository = empRepository;
		this.salaryRepository = salaryRepository;
	}


//method for Salary details
	public List<SalaryProcessor> getSalaryForDate(Date date) {
		Iterable<Salary> salaryAll = this.salaryRepository.findAll();
		Iterable<Employee> empAll = this.empRepository.findAll();

		Map<Long, SalaryProcessor> salaryProcessedMap = new HashMap<>();
		Map<Long, Employee> empMap = new HashMap<>();

		empAll.forEach(empDetail -> {
			empMap.put(empDetail.getEmpid(), empDetail);
		});

		salaryAll.forEach(salary -> {
			SalaryProcessor salProcessed = new SalaryProcessor();
			salProcessed.setBillid(salary.getBillid());
			salProcessed.setEmpId(salary.getEmpId());
			salProcessed.setEmpName(empMap.get(salary.getEmpId()).getFirstName());
			salProcessed.setFactoryId(salary.getFactoryId());
			salProcessed.setMetresWeaved(salary.getMetresWeaved());
			salProcessed.setAmountPaid(salary.getAmountPaid());
			salaryProcessedMap.put(salary.getBillid(), salProcessed);
		});

		List<SalaryProcessor> salaryList = new ArrayList<>();
		for (Long billId : salaryProcessedMap.keySet()) {
			salaryList.add(salaryProcessedMap.get(billId));
		}
		return salaryList;
	}

	/*
	 * method for Salary processing logic
	 */
	public String processSalaryForDate(Date date) {
		Map<Long, Salary> unprocessedSalary = stockService.listAllUnprocessSal();
		for (Long empId : unprocessedSalary.keySet()) {
			if (unprocessedSalary.get((empId)) != null) {
				System.out.println("Key" + empId + "Salary-" + unprocessedSalary.get((empId)).getMetresWeaved());
				unprocessedSalary.get((empId)).setDate(new Date());
				float amountPaid = unprocessedSalary.get((empId)).getMetresWeaved() * 1.60f;
				// amount calculation needed
				unprocessedSalary.get(empId).setAmountPaid(amountPaid);
				saveSalary(unprocessedSalary.get((empId)));
				System.out.println("Key" + empId + "Saved-");
			}
		}

		return "success";
	}

	//method to save the salary
	public Salary saveSalary(Salary salary) {
		// set the unprocessed state before insert
		return salaryRepository.save(salary);
	}
}
