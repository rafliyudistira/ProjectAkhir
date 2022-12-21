package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.anggotakeluargamodel;
import com.example.demo.repository.IanggotakeluargaRepo;
import com.example.demo.service.IanggotakeluargaService;

@Service
public class anggotakeluargaService implements IanggotakeluargaService {
	@Autowired
	IanggotakeluargaRepo ianggotakeluargaRepo;

	@Override
	public anggotakeluargamodel insertAnggotakeluarga(anggotakeluargamodel anggotakeluarga) {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.insertAnggotakeluarga(anggotakeluarga);
	}

	@Override
	public List<anggotakeluargamodel> getAllanggota() {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.getAllanggota();
	}

	@Override
	public anggotakeluargamodel deleteAnggota(long id) {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.deleteAnggota(id);
	}

	@Override
	public anggotakeluargamodel updateAnggota(long id, anggotakeluargamodel anggotakeluarga) {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.updateAnggota(id, anggotakeluarga);
	}

	@Override
	public List<anggotakeluargamodel> getIdKk(int id_kk) {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.getIdKk(id_kk);
	}

	@Override
	public anggotakeluargamodel getAnggotaById(long id) {
		// TODO Auto-generated method stub
		return ianggotakeluargaRepo.getAnggotaById(id);
	}
	 @Override
	    public List<anggotakeluargamodel> deleteAllAnggota(String id_kk) {

	        return ianggotakeluargaRepo.deleteAllAnggota(id_kk);
	    }
	
	

}
