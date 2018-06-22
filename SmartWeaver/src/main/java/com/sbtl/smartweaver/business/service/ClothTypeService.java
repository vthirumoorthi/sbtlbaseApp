package com.sbtl.smartweaver.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.sbtl.smartweaver.data.entity.ClothType;
import com.sbtl.smartweaver.data.repository.ClothRepository;

import org.springframework.stereotype.Service;

@Service
public class ClothTypeService {
	 
	private ClothRepository clothTypeRepository;
	
	@Autowired
	    public ClothTypeService(ClothRepository clothTypeRepository) {
		this.clothTypeRepository = clothTypeRepository;
	}

		public Iterable<ClothType> listAllClothProdTypes() {
	        return clothTypeRepository.findAll();
	    }

	    public Optional<ClothType> getClothTypeById(long id) {
	        return clothTypeRepository.findById(id);
	    }
	
	    public ClothType saveClothType(ClothType cloth) {
	        return clothTypeRepository.save(cloth);
	    }

	    public void deleteClothType(long id) {
	    	clothTypeRepository.deleteById(id);
	    }
}
