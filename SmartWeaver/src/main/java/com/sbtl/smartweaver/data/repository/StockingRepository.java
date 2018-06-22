package com.sbtl.smartweaver.data.repository;

import com.sbtl.smartweaver.data.entity.Stocking;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockingRepository extends CrudRepository<Stocking, Long>{

	@Query(value = "select * from CLOTHSTOCK  where "
			+ "SALARY_PROCESS ='U' ",nativeQuery=true)
	public List<Stocking> findASalUnProcessEmpwise();
	
	
	/*@Query( "select cs from CLOTHSTOCK cs where DELIVERY_PROCESS ='U'" )
	Iterable<Stocking> findAllDeliUnProcessed();*/

}
