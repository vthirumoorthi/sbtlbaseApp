package com.sbtl.smartweaver.data.repository;


import com.sbtl.smartweaver.data.entity.Loom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoomRepository extends CrudRepository<Loom, Long> {

	Loom findByLoomId(long loomId);


   
}