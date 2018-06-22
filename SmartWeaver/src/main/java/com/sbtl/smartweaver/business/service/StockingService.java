package com.sbtl.smartweaver.business.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtl.smartweaver.data.entity.Loom;
import com.sbtl.smartweaver.data.entity.Salary;
import com.sbtl.smartweaver.data.entity.Stocking;
import com.sbtl.smartweaver.data.repository.LoomRepository;
import com.sbtl.smartweaver.data.repository.StockingRepository;

@Service
public class StockingService {
	 private StockingRepository stockRepository ;
	 private LoomRepository loomRepository;
	 
	 @Autowired
	    public void setStockingRepository(StockingRepository stockRepository, LoomRepository loomRepository) {
	        this.stockRepository = stockRepository;
	        this.loomRepository=loomRepository;
	    }
	 public Iterable<Stocking> listAllStocks() {
	        return stockRepository.findAll();
	    }

	    public Optional<Stocking> getStockById(long id) {
	        return stockRepository.findById(id);
	    }

	   //method to save the stock to H2
	    public Stocking saveStock(Stocking pc) {
	    	//set the unprocessed state before insert
	    	pc.setEntryDate(new java.util.Date());
	    	pc.setSalProcessed("U");
	    	pc.setProcessedState("U");
	        return stockRepository.save(pc);
	    }
	    //method to delete the stock
	    public void deleteStock(long pcid) {
	    	stockRepository.deleteById(pcid);
	    }
	    //method to retreive factory id from loom respository
		private long getFactoryId(long loomId) {
			long factoryId = -1;
			Loom loomdetail = loomRepository.findByLoomId(loomId);
			if (loomdetail != null) {
				factoryId = loomdetail.getFactoryId();
			}
			return factoryId;

		}
		//method doing salary processing for the unprocessed pcs
	    public Map<Long,Salary> listAllUnprocessSal() {
/*	    	Map<Long,Stocking> unprocessMetres= new HashMap<>();*/
	    	Map<Long,Salary> unprocessedSalary = new HashMap<>();
	    	if(0!=stockRepository.findASalUnProcessEmpwise().size()) {
	    	List<Stocking> unprocessedStocks = stockRepository.findASalUnProcessEmpwise();
	    	unprocessedStocks.forEach(stockDetail->{
	    		System.out.println("Key = " + stockDetail.getPcId() +
                        ", Value = " + stockDetail.getMeteresWeaved());
	    		Salary salaryProcess = new Salary();
	    		long factoryId= getFactoryId(stockDetail.getLoomId());
	    		salaryProcess.setFactoryId(factoryId);
	    		if(!unprocessedSalary.containsKey(stockDetail.getEmpId())) {
	    			salaryProcess.setEmpId(stockDetail.getEmpId());
	    			float totalMetres =stockDetail.getMeteresWeaved();
	    			salaryProcess.setMetresWeaved(totalMetres);
	    			unprocessedSalary.put(stockDetail.getEmpId(), salaryProcess);
	    		}
	    		else {
	    			 salaryProcess =unprocessedSalary.get(stockDetail.getEmpId());
	    			 float totalMetres =salaryProcess.getMetresWeaved()+stockDetail.getMeteresWeaved();
	    			 salaryProcess.setMetresWeaved(totalMetres);
	    			 unprocessedSalary.put(stockDetail.getEmpId(), salaryProcess);
	    		}
	        });
	    	}
	        return unprocessedSalary;
	    }
	   /* public Iterable<Stocking> listAllUnprocessDelivery() {
	        return stockRepository.findAllDeliUnProcessed();
	    }*/
}
