package com.example.demo.service;

import java.util.List;

import com.example.demo.model.anggotakeluargamodel;
import com.example.demo.model.kartukeluargamodel;
public interface IanggotakeluargaService {
	public anggotakeluargamodel insertAnggotakeluarga (anggotakeluargamodel anggotakeluarga);
	public List<anggotakeluargamodel> getAllanggota();
	public anggotakeluargamodel updateAnggota(long id, anggotakeluargamodel anggotakeluarga);
	public anggotakeluargamodel deleteAnggota (long id);
	public List<anggotakeluargamodel> getIdKk(int id_kk);
	public anggotakeluargamodel getAnggotaById (long id);
	public List<anggotakeluargamodel> deleteAllAnggota(String id_kk);
}
