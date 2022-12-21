package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.kartukeluargamodel;
import com.example.demo.service.IkartukeluargaService;
import com.example.demo.repository.IkartukeluargaRepo;

@Service
public class kartukeluargaService implements IkartukeluargaService {
	
	@Autowired
	IkartukeluargaRepo ikartukeluargaRepo;
	

	@Override
	public kartukeluargamodel insertKartukeluarga(kartukeluargamodel kartukeluarga) {
		// TODO Auto-generated method stub
		return ikartukeluargaRepo.insertKartukeluarga(kartukeluarga);
	}


	@Override
	public List<kartukeluargamodel> getAllkartu() {
		// TODO Auto-generated method stub
		return ikartukeluargaRepo.getAllkartu();
	}


	@Override
	public kartukeluargamodel updateKartu(long id, kartukeluargamodel kartukeluarga) {
		// TODO Auto-generated method stub
		return ikartukeluargaRepo.updateKartu(id, kartukeluarga);
	}

	@Override
	public kartukeluargamodel deleteKartu(long id) {
		// TODO Auto-generated method stub
		return ikartukeluargaRepo.deleteKartu(id);
	}


	@Override
	public kartukeluargamodel getKartuById(long id) {
		// TODO Auto-generated method stub
		return ikartukeluargaRepo.getKartuById(id);
	}

}
