package com.sbtl.smartweaver.data.repository;

import com.sbtl.smartweaver.data.entity.ClothType;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothRepository extends CrudRepository<ClothType, Long>{

	Iterable<ClothType> findAll();
	Optional<ClothType> findByClothId(long id);
	
}
