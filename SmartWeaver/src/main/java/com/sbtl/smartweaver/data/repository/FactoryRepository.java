package com.sbtl.smartweaver.data.repository;

import com.sbtl.smartweaver.data.entity.Factory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FactoryRepository extends CrudRepository<Factory, Long> {

	Factory findByfactoryId(long facId);
   
}